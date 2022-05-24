package com.ssafy.vue.mapper;

import com.ssafy.vue.dto.Board;
import com.ssafy.vue.dto.BoardComment;

import java.util.List;

public interface BoardCommentMapper {
    public List<BoardComment> selectBoardCommentByArticleNo(int articleno);
    public int insertBoardComment(BoardComment boardComment);
}
