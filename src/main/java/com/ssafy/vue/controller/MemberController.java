package com.ssafy.vue.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssafy.vue.dto.MemberDto;
import com.ssafy.vue.service.JwtServiceImpl;
import com.ssafy.vue.service.MemberService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api("MemberController V1")
@RestController
@RequestMapping("/user")
public class MemberController {

    public static final Logger logger = LoggerFactory.getLogger(MemberController.class);
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    @Autowired
    private JwtServiceImpl jwtService;

    @Autowired
    private MemberService memberService;

    @ApiOperation(value = "회원가입", notes = "회원가입을 진행하고 결과메시지를 반환한다.", response = String.class)
    @PostMapping
    public ResponseEntity<Map<String, Object>> registerMember(@Valid @RequestBody @ApiParam(value = "회원가입시 필요한 회원정보(아이디, 비밀번호,회원이름,이메일).", required = true) MemberDto memberDto) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();

        if (memberService.checkMemberIsDuplicate(memberDto.getUserid())) {
            resultMap.put("message", FAIL);
            return ResponseEntity.status(HttpStatus.CONFLICT)
                                 .body(resultMap);
        }

        memberService.insertInfo(memberDto);
        resultMap.put("message", SUCCESS);
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(resultMap);
    }

    @ApiOperation(value = "회원탈퇴", notes = "회원탈퇴를 진행하고 결과메시지를 반환한다.", response = String.class)
    @DeleteMapping
    public ResponseEntity<Map<String, Object>> deleteMember(@RequestBody @ApiParam(value = "회원탈퇴시 필요한 회원정보(아이디).", required = true) MemberDto memberDto) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        int result = memberService.deleteInfo(memberDto.getUserid());
        if (result > 0) {
            resultMap.put("message", SUCCESS);
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                                 .body(resultMap);
        }
        resultMap.put("message", FAIL);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                             .body(resultMap);
    }

    @ApiOperation(value = "회원정보변경", notes = "회원정보를 변경하고 결과메시지를 반환한다.", response = String.class)
    @PatchMapping
    public ResponseEntity<Map<String, Object>> updateMember(@Valid @RequestBody @ApiParam(value = "회원변경시 필요한 회원정보는 선택적으로 변경됨.", required = true) MemberDto memberDto) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        int result = memberService.updateInfo(memberDto);
        if (result > 0) {
            resultMap.put("message", SUCCESS);
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                                 .body(resultMap);
        }
        resultMap.put("message", FAIL);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                             .body(resultMap);
    }

    @ApiOperation(value = "로그인", notes = "Access-token과 로그인 결과 메세지를 반환한다.", response = Map.class)
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(
            @RequestBody @ApiParam(value = "로그인 시 필요한 회원정보(아이디, 비밀번호).", required = true) MemberDto memberDto) {
    	System.out.println(memberDto.toString());
    	System.out.println(memberDto.getUserpwd());
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;
        try {
            MemberDto loginUser = memberService.login(memberDto);
            if (loginUser != null) {
                String token = jwtService.create("userid", loginUser.getUserid(), "access-token");// key, data, subject
                logger.debug("로그인 토큰정보 : {}", token);
                resultMap.put("access-token", token);
                resultMap.put("message", SUCCESS);
                status = HttpStatus.ACCEPTED;
            } else {
                resultMap.put("message", FAIL);
                status = HttpStatus.ACCEPTED;
            }
        } catch (Exception e) {
            logger.error("로그인 실패 : {}", e);
            resultMap.put("message", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    @ApiOperation(value = "회원인증", notes = "회원 정보를 담은 Token을 반환한다.", response = Map.class)
    @GetMapping("/info/{userid}")
    public ResponseEntity<Map<String, Object>> getInfo(
            @PathVariable("userid") @ApiParam(value = "인증할 회원의 아이디.", required = true) String userid,
            HttpServletRequest request) {
        logger.debug("userid : {} ", userid);
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        if (jwtService.isUsable(request.getHeader("access-token"))) {
            logger.info("사용 가능한 토큰!!!");
            try {
//				로그인 사용자 정보.
                MemberDto memberDto = memberService.selectInfo(userid);
                resultMap.put("userInfo", memberDto);
                resultMap.put("message", SUCCESS);
                status = HttpStatus.ACCEPTED;
            } catch (Exception e) {
                logger.error("정보조회 실패 : {}", e);
                resultMap.put("message", e.getMessage());
                status = HttpStatus.INTERNAL_SERVER_ERROR;
            }
        } else {
            logger.error("사용 불가능 토큰!!!");
            resultMap.put("message", FAIL);
            status = HttpStatus.ACCEPTED;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }


}
