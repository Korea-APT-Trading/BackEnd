package com.ssafy.vue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.vue.dto.Qna;
import com.ssafy.vue.mapper.QnaMapper;

@Service
public class QnaServiceImpl implements QnaService {

	@Autowired
	private QnaMapper qnaMapper;
	
	@Override
	public List<Qna> showQna() {
		return qnaMapper.selectQna();
	}

	@Override
	public Qna detailQna(int articleno) {
		return qnaMapper.selectQnaByNo(articleno);
	}

	@Override
	public boolean writeQna(Qna qna) {
		return qnaMapper.insertQna(qna) == 1;
	}

	@Override
	public boolean updateQna(Qna qna) {
		return qnaMapper.updateQna(qna) == 1;
	}

	@Override
	public boolean deleteQna(int articleno) {
		return qnaMapper.deleteQna(articleno) == 1;
	}

	@Override
	public void updateHit(int articleno) {
		qnaMapper.updateHit(articleno);
	}

	
}
