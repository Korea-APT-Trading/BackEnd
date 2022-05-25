package com.ssafy.vue.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vue.dto.QnaComment;

@Mapper
public interface QnaCommentMapper {
	public List<QnaComment> selectQnaComment();
	public List<QnaComment> selectQnaCommentByNo(int articleno);
	public int insertQnaComment(QnaComment qnacomment);
	public int updateQnaComment(QnaComment qnacomment);
	public int deleteQnaComment(int articleno);
}
