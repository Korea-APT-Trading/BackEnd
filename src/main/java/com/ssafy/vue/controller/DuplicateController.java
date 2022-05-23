package com.ssafy.vue.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.vue.service.MemberService;

@RestController
public class DuplicateController {

@Autowired
private MemberService memberService;
private static final String SUCCESS = "success";
private static final String FAIL = "fail";

@GetMapping("/user-id/{userid}")
public ResponseEntity<Map<String, Object>> checkUserIdDuplicate(@PathVariable String userid) throws Exception {
    Map<String, Object> resultMap = new HashMap<>();
    if(memberService.checkMemberIsDuplicate(userid)){
        resultMap.put("message", FAIL);
    } else{
        resultMap.put("message", SUCCESS);
    }
    return ResponseEntity.ok(resultMap);
}
}