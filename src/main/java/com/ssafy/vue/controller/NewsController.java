package com.ssafy.vue.controller;

import com.ssafy.vue.dto.Board;
import com.ssafy.vue.dto.BoardComment;
import com.ssafy.vue.dto.Item;
import com.ssafy.vue.service.BoardCommentService;
import com.ssafy.vue.service.BoardService;
import com.ssafy.vue.service.JwtService;
import com.ssafy.vue.service.NewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Api("NewsController V1")
@RestController
@RequestMapping("/news")
public class NewsController {

        private static final Logger logger = LoggerFactory.getLogger(com.ssafy.vue.controller.BoardController.class);
        private static final String SUCCESS = "success";
        private static final String FAIL = "fail";

        @Autowired
        NewsService newsService;

        @ApiOperation(value = "최신 뉴스 목록", notes = "모든 뉴스의 정보를 반환한다.", response = List.class)
        @GetMapping
        public ResponseEntity<List<Item>> retrieveNews() throws Exception {
            logger.debug("retrieveNews - 호출");
            return new ResponseEntity<List<Item>>(newsService.retrieveNews(), HttpStatus.OK);
        }


}
