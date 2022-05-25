package com.ssafy.vue.service;

import com.ssafy.vue.dto.MemberDto;
import com.ssafy.vue.mapper.MemberMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JwtServiceImplTest {

    @Autowired
    JwtService jwtService;

    @Test
    @DisplayName("토큰 발행 인증 테스트")
    public void tokenAccessTest() throws Exception {
        //given
        MemberDto memberDto = makeMemberDto();

        String token = jwtService.create("userid", memberDto.getUserid(), "access-token");// key, data, subject
        if (jwtService.isUsable(token)) {
            System.out.println(token);
        } else {
            fail();
        }
    }

    @Test
    @DisplayName("토큰에서 userId 꺼내오기 테스트")
    public void getUserIdByToken() throws Exception {
        //given
        String SALT = "ssafySecret";
        MemberDto memberDto = makeMemberDto();
        String token = jwtService.create("userid", memberDto.getUserid(), "access-token");// key, data, subject

        //when
        String userIdByToken = jwtService.getUserIdByToken(token);

        //then
        Assertions.assertThat(userIdByToken).isEqualTo("junwoo");
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