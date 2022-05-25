package com.ssafy.vue.service;

import java.util.List;

import com.ssafy.vue.dto.QnaComment;

public interface QnaCommentService {
	public List<QnaComment> showQnaComment();
	public List<QnaComment> showQnaCommentByNo(int articleno);
	public boolean writeQnaComment(QnaComment qnacomment);
	public boolean updateQnaComment(QnaComment qnacomment);
	public boolean deleteQnaComment(int articleno);
}
