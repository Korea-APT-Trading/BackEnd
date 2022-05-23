package com.ssafy.vue.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.vue.dto.Board;
import com.ssafy.vue.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	
    @Autowired
	private BoardMapper boardMapper;

    @Override
	public List<Board> retrieveBoard() {
		return boardMapper.selectBoard();
	}
    
  	@Override
	public boolean writeBoard(Board board) {
		return boardMapper.insertBoard(board) == 1;
	}

	@Override
	public Board detailBoard(int articleno) {
		return boardMapper.selectBoardByNo(articleno);
	}
	
	@Override
	public void updateHit(int articleno) {
		boardMapper.updateHit(articleno);
	}

	@Override
	@Transactional
	public boolean updateBoard(Board board, String userId) {
		if(userId.equals("admin")){
			return boardMapper.forceUpdateBoard(board) ==1;
		}
		Map<String, Object> updateInfo = new HashMap<>();
		updateInfo.put("board", board);
		updateInfo.put("userid",userId);
		return boardMapper.updateBoard(updateInfo) == 1;
	}

	@Override
	@Transactional
	public boolean deleteBoard(int articleno, String userId) {
		if(userId.equals("admin")){
			return boardMapper.forceDeleteBoard(articleno) ==1;
		}

		Map<String,Object> deleteInfo = new HashMap<>();
		deleteInfo.put("articleno",articleno);
		deleteInfo.put("userid",userId);
		return boardMapper.deleteBoard(deleteInfo) == 1;
	}
}