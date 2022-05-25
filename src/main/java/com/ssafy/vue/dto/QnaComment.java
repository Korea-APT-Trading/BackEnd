package com.ssafy.vue.dto;

public class QnaComment {	
	private int articleno;
	private int qnano;
	private String userid;
	private String content;
	private String regtime;
	
	public QnaComment() {
		// TODO Auto-generated constructor stub
	}

	public QnaComment(int articleno, int qnano, String userid, String content, String regtime) {
		super();
		this.articleno = articleno;
		this.qnano = qnano;
		this.userid = userid;
		this.content = content;
		this.regtime = regtime;
	}

	public int getArticleno() {
		return articleno;
	}

	public void setArticleno(int articleno) {
		this.articleno = articleno;
	}

	public int getQnano() {
		return qnano;
	}

	public void setQnano(int qnano) {
		this.qnano = qnano;
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

	@Override
	public String toString() {
		return "QnaComment [articleno=" + articleno + ", qnano=" + qnano + ", userid=" + userid + ", content=" + content
				+ ", regtime=" + regtime + "]";
	}
}
