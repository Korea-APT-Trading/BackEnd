package com.ssafy.vue.service;

import java.util.List;

import com.ssafy.vue.dto.BoardComment;

public interface BoardCommentService {
    public List<BoardComment> SearchBoardCommentsByArticleNo(int articleno);
    public boolean writeBoardComment(BoardComment boardComment);
}
