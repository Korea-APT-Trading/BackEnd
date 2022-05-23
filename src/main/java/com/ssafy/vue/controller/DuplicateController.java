package com.ssafy.vue.controller;

import com.ssafy.vue.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DuplicateController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/user-id/{userid}")
    public ResponseEntity<Boolean> checkUserIdDuplicate(@PathVariable String userid) throws Exception {
        return ResponseEntity.ok(memberService.checkMemberIsDuplicate(userid));
    }
}
