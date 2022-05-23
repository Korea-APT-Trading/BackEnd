package com.ssafy.vue.mapper;

import java.sql.SQLException;

import com.ssafy.vue.dto.MemberDto;
import org.apache.ibatis.jdbc.SQL;


public interface MemberMapper {

	public MemberDto login(MemberDto memberDto) throws SQLException;
	public MemberDto selectInfo(String userId) throws SQLException;
	public int updateInfo(MemberDto memberDto) throws SQLException;
	public int deleteInfo(String userId) throws SQLException;
	public int insertInfo(MemberDto memberDto) throws SQLException;
}