package com.ssafy.vue.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.vue.dto.QnaComment;
import com.ssafy.vue.service.QnaCommentService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/qnacomment")
public class QnaCommentController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private QnaCommentService qnaCommentService;
	
	@GetMapping
	public ResponseEntity<List<QnaComment>> showQnaComment() throws Exception {
		logger.debug("showQnaComment - 호출");
		return new ResponseEntity<List<QnaComment>>(qnaCommentService.showQnaComment(), HttpStatus.OK);
	}
	
	@GetMapping("{articleno}")
	public ResponseEntity<List<QnaComment>> showQnaCommentByNo(@PathVariable int articleno) {
		logger.debug("showQnaCommentByNo - 호출");
		return new ResponseEntity<List<QnaComment>>(qnaCommentService.showQnaCommentByNo(articleno), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> writeQnaComment(@RequestBody QnaComment qnacomment){
		logger.debug("writeQnaComment - 호출");
		
		if (qnaCommentService.writeQnaComment(qnacomment))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("{articleno}")
	public ResponseEntity<String> updateQnaComment(@RequestBody QnaComment qnacomment){
		logger.debug("updateQnaComment - 호출");
		
		if (qnaCommentService.updateQnaComment(qnacomment))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("{articleno}")
	public ResponseEntity<String> deleteQnaComment(@PathVariable int articleno) {
		logger.debug("deleteQnaComment - 호출");
		if (qnaCommentService.deleteQnaComment(articleno))
			return new ResponseEntity<String> (SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
}
