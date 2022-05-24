package com.ssafy.vue.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "BoardComment (게시글 댓글 정보)", description = "글번호, 내용, 작성자아이디, 작성일을 가진 Domain Class")
public class BoardComment {
    @ApiModelProperty(value = "댓글번호")
    private int boardcommentno;

    @ApiModelProperty(value = "글번호")
    private int articleno;

    @ApiModelProperty(value = "작성자아이디")
    private String userid;

    @ApiModelProperty(value = "내용")
    private String content;

    @ApiModelProperty(value = "작성일")
    private String regtime;

    public int getBoardcommentno() {
        return boardcommentno;
    }

    public void setBoardcommentno(int boardcommentno) {
        this.boardcommentno = boardcommentno;
    }

    public int getArticleno() {
        return articleno;
    }

    public void setArticleno(int articleno) {
        this.articleno = articleno;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRegtime() {
        return regtime;
    }

    public void setRegtime(String regtime) {
        this.regtime = regtime;
    }

    public BoardComment(int boardcommentno, int articleno, String userid, String content, String regtime) {
        this.boardcommentno = boardcommentno;
        this.articleno = articleno;
        this.userid = userid;
        this.content = content;
        this.regtime = regtime;
    }

    @Override
    public String toString() {
        return "BoardComment{" +
                "boardcommentno=" + boardcommentno +
                ", articleno=" + articleno +
                ", userid='" + userid + '\'' +
                ", content='" + content + '\'' +
                ", regtime='" + regtime + '\'' +
                '}';
    }
}