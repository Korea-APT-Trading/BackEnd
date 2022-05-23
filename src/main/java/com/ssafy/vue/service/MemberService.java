package com.ssafy.vue.service;

import com.ssafy.vue.dto.MemberDto;

public interface MemberService {

	public MemberDto login(MemberDto memberDto) throws Exception;
	public MemberDto selectInfo(String userid) throws Exception;
	public int updateInfo(MemberDto memberDto) throws Exception;
	public int deleteInfo(String userId) throws Exception;
	public int insertInfo(MemberDto memberDto) throws Exception;
	public MemberDto hasingPassword(MemberDto memberDto);
	public boolean checkMemberIsDuplicate(String userId) throws Exception;
}
