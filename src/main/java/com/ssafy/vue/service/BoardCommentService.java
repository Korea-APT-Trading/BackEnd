package com.ssafy.vue.service;

import com.ssafy.vue.dto.Board;
import com.ssafy.vue.dto.BoardComment;

import java.util.List;

public interface BoardCommentService {
    public List<BoardComment> SearchBoardCommentsByArticleNo(int articleno);
    public boolean writeBoardComment(BoardComment boardComment);
}
