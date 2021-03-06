package com.arc.b1.board;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

public class NoticeVO {

	private int num;
	@NotEmpty//(message = "Title을 작성해주세요")
	private String title;
	private String writer;
	private String contents;
	private Date regDate;
	private int hit;
	
	private NoticeFilesVO noticeFilesVO;

	
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public NoticeFilesVO getNoticeFilesVO() {
		return noticeFilesVO;
	}
	public void setNoticeFilesVO(NoticeFilesVO noticeFilesVO) {
		this.noticeFilesVO = noticeFilesVO;
	}
}
