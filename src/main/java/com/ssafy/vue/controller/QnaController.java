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

import com.ssafy.vue.dto.Qna;
import com.ssafy.vue.service.QnaService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/qna")
public class QnaController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private QnaService qnaService;
	
	@GetMapping
	public ResponseEntity<List<Qna>> showQna() throws Exception {
		logger.debug("showQna - 호출");
		return new ResponseEntity<List<Qna>>(qnaService.showQna(), HttpStatus.OK);
	}
	
	@GetMapping("{articleno}")
	public ResponseEntity<Qna> detailQna(@PathVariable int articleno) {
		logger.debug("detailQna - 호출");
		qnaService.updateHit(articleno);
		return new ResponseEntity<Qna>(qnaService.detailQna(articleno), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> writeQna(@RequestBody Qna qna){
		logger.debug("writeQna - 호출");
		
		if (qnaService.writeQna(qna))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@PutMapping("{articleno}")
	public ResponseEntity<String> updateQna(@RequestBody Qna qna){
		logger.debug("updateQna - 호출");
		
		if (qnaService.updateQna(qna))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("{articleno}")
	public ResponseEntity<String> deleteQna(@PathVariable int articleno){
		logger.debug("deleteQna - 호출");
		
		if (qnaService.deleteQna(articleno))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
}
