package com.ssafy.vue.dto;

public class Qna {
	private int articleno;
	private String userid;
	private String subject;
	private String content;
	private int hit;
	private String regtime;
	
	public Qna() {
		// TODO Auto-generated constructor stub
	}
	
	public Qna(int articleno, String userid, String subject, String content, int hit, String regtime) {
		super();
		this.articleno = articleno;
		this.userid = userid;
		this.subject = subject;
		this.content = content;
		this.hit = hit;
		this.regtime = regtime;
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}

	@Override
	public String toString() {
		return "Qna [articleno=" + articleno + ", userid=" + userid + ", subject=" + subject + ", content=" + content
				+ ", hit=" + hit + ", regtime=" + regtime + "]";
	}

}
