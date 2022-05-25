package com.ssafy.vue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.vue.dto.QnaComment;
import com.ssafy.vue.mapper.QnaCommentMapper;

@Service
public class QnaCommentServiceImpl implements QnaCommentService {

	@Autowired
	private QnaCommentMapper qnaCommentMapper;
	
	@Override
	public List<QnaComment> showQnaComment() {
		return qnaCommentMapper.selectQnaComment();
	}
	
	@Override
	public List<QnaComment> showQnaCommentByNo(int articleno){
		return qnaCommentMapper.selectQnaCommentByNo(articleno);
	}
	
	@Override
	public boolean writeQnaComment(QnaComment qnacomment) {
		return qnaCommentMapper.insertQnaComment(qnacomment) == 1;
	}

	@Override
	public boolean updateQnaComment(QnaComment qnacomment) {
		return qnaCommentMapper.updateQnaComment(qnacomment) == 1;
	}

	@Override
	public boolean deleteQnaComment(int articleno) {
		return qnaCommentMapper.deleteQnaComment(articleno) == 1;
	}

}
