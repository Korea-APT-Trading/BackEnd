package com.ssafy.vue.service;

import com.ssafy.vue.dto.MemberDto;
import com.ssafy.vue.mapper.MemberMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceImplTest {

    @Autowired
    MemberMapper memberMapper;

    @Autowired
    MemberService memberService;

    @Test
    @DisplayName("암호화 테스트")
    public void hashingTest() throws Exception {
        //given
        MemberDto memberDto = new MemberDto();
        String userId = "ssafy";
        String userPassword = "ssafy";
        memberDto.setUserid(userId);
        memberDto.setUserpwd(userPassword);

        //when
        memberDto = memberService.hasingPassword(memberDto);

        //then
        Assertions.assertThat(userPassword)
                  .isNotEqualTo(memberDto.getUserpwd());
    }

    @Test
    @DisplayName("회원가입 테스트")
    public void joinTest() throws Exception {
        //given
        MemberDto memberDto = makeMemberDto();

        //when
        memberService.insertInfo(memberDto);

        //then
        MemberDto result = memberService.selectInfo("junwoo");
        Assertions.assertThat(result.getUserid())
                  .isEqualTo("junwoo");
    }

    @Test
    @DisplayName("회원가입 중복검사실패   테스트")
    public void memberIdDuplicateTest() throws Exception {
        //given
        MemberDto memberDto1 = makeMemberDto();
        MemberDto memberDto2 = makeMemberDto();

        memberService.insertInfo(memberDto1);

        //when
        if (memberService.checkMemberIsDuplicate(memberDto2.getUserid())) {
            return;
        }

        //then
        fail();
    }

    @Test
    @DisplayName("회원가입 중복검사성공 테스트")
    public void memberIdNonDuplicateTest() throws Exception {
        //given
        MemberDto memberDto1 = makeMemberDto();
        MemberDto memberDto2 = makeMemberDto();
        memberDto2.setUserid("Other");

        memberService.insertInfo(memberDto1);

        //when
        if (memberService.checkMemberIsDuplicate(memberDto2.getUserid())) {
            fail();
        }

        //then

    }

    @Test
    @DisplayName("로그인 테스트")
    public void memberLoginTest() throws  Exception{
        //given
        MemberDto memberDto = makeMemberDto();
        memberService.insertInfo(memberDto);
        memberDto.setUserpwd("1234");

        //when
        MemberDto result = memberService.login(memberDto);

        //then
        Assertions.assertThat(result.getUserid()).isEqualTo(memberDto.getUserid());
    }

    @Test
    @DisplayName("로그인 실패 테스트")
    public void memberLoginFailTest() throws  Exception{
        //given
        MemberDto memberDto = makeMemberDto();
        memberService.insertInfo(memberDto);
        memberDto.setUserpwd("Wrong Password");

        //when
        MemberDto result = memberService.login(memberDto);

        //then
        Assertions.assertThat(result).isNull();
    }

    @Test
    @DisplayName("회원 탈퇴 테스트")
    public void memberDeleteTest() throws  Exception{
        //given
        MemberDto memberDto = makeMemberDto();
        memberService.insertInfo(memberDto);

        //when
        memberService.deleteInfo(memberDto.getUserid());

        //then
        Assertions.assertThat(memberService.selectInfo(memberDto.getUserid())).isNull();
    }

    @Test
    @DisplayName("회원 수정 테스트")
    public void memberUpdateTest() throws  Exception{
        //given
        MemberDto memberDto = makeMemberDto();
        memberService.insertInfo(memberDto);

        memberDto.setUsername("changed");

        //when
        memberService.updateInfo(memberDto);

        //then
        Assertions.assertThat(memberService.selectInfo(memberDto.getUserid()).getUsername()).isEqualTo("changed");
    }

    public MemberDto makeMemberDto() {
        MemberDto memberDto = new MemberDto();
        memberDto.setUserid("junwoo");
        memberDto.setUserpwd("1234");
        memberDto.setUsername("jun");
        memberDto.setEmail("bababrll@naver.com");
        return memberDto;
    }



}