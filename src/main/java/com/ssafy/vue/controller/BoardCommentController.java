package com.ssafy.vue.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.vue.dto.BoardComment;
import com.ssafy.vue.service.BoardCommentService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/boardcomment")
public class BoardCommentController {
	 private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	 private static final String SUCCESS = "success";
	 private static final String FAIL = "fail";
	
	 @Autowired
	    private BoardCommentService boardCommentService;
	 
	@ApiOperation(value = "게시판 댓글등록", notes = "새로운 게시글 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping("")
	public ResponseEntity<String> writeBoardComment(@RequestBody BoardComment boardComment) {
		logger.debug("writeBoardComment - 호출");


		if (boardCommentService.writeBoardComment(boardComment)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}
	
	@GetMapping("{articleno}")
	public ResponseEntity<List<BoardComment>> showBoardCommentByNo(@PathVariable int articleno) {
		logger.debug("showBoardCommentByNo - 호출");
		return new ResponseEntity<List<BoardComment>>(boardCommentService.SearchBoardCommentsByArticleNo(articleno), HttpStatus.OK);
	}
}
