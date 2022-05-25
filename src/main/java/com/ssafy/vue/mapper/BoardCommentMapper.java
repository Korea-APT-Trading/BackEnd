package com.ssafy.vue.mapper;

import java.util.List;

import com.ssafy.vue.dto.BoardComment;

public interface BoardCommentMapper {
    public List<BoardComment> selectBoardCommentByArticleNo(int articleno);
    public int insertBoardComment(BoardComment boardComment);
}
