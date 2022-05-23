package com.ssafy.vue.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vue.dto.Board;
@Mapper
public interface BoardMapper {
	public List<Board> selectBoard();
	public Board selectBoardByNo(int articleno);
	public void updateHit(int articleno);
	public int insertBoard(Board board);
	public int updateBoard(Map<String,Object> updateInfo);
	public int deleteBoard(Map<String,Object> deleteInfo);
	public int forceUpdateBoard(Board board);
	public int forceDeleteBoard(int articleno);
}