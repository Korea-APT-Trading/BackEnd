package com.ssafy.vue.service;

import java.util.List;

import com.ssafy.vue.dto.Board;

public interface BoardService {
	public List<Board> retrieveBoard();
	public List<Board> retrieveTopFiveHitBoard();
	public Board detailBoard(int articleno);
	public void updateHit(int articleno);
	public boolean writeBoard(Board board);
	public boolean updateBoard(Board board,String userId);
	public boolean deleteBoard(int articleno, String userId);
}
