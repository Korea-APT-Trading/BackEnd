package com.ssafy.vue.service;

import com.ssafy.vue.dto.BoardComment;
import com.ssafy.vue.mapper.BoardCommentMapper;
import com.ssafy.vue.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardCommentImpl implements BoardCommentService{

    @Autowired
    private BoardCommentMapper boardCommentMapper;

    @Override
    public List<BoardComment> SearchBoardCommentsByArticleNo(int articleno) {
        return boardCommentMapper.selectBoardCommentByArticleNo(articleno);
    }

    @Override
    public boolean writeBoardComment(BoardComment boardComment) {
        return boardCommentMapper.insertBoardComment(boardComment) == 1;
    }
}
