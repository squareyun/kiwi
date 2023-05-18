package com.ssafy.kiwi.board.model;

import org.springframework.stereotype.Component;

@Component
public class BoardDto {

	private int boardno;
	private String title;
	private String content;
	private String createdate;
	private int hit;
	private int scope;
	private int userno;
	private String nickname;
	private int cntLike;
	private int cntReply;
	private int islike;
	
	
	public int getCntLike() {
		return cntLike;
	}

	public void setCntLike(int cntLike) {
		this.cntLike = cntLike;
	}

	public int getCntReply() {
		return cntReply;
	}

	public void setCntReply(int cntReply) {
		this.cntReply = cntReply;
	}

	public int getIslike() {
		return islike;
	}

	public void setIslike(int islike) {
		this.islike = islike;
	}

	public int getBoardno() {
		return boardno;
	}

	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getScope() {
		return scope;
	}

	public void setScope(int scope) {
		this.scope = scope;
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "BoardDto [boardno=" + boardno + ", title=" + title + ", content=" + content + ", createdate="
				+ createdate + ", hit=" + hit + ", scope=" + scope + ", userno=" + userno + ", nickname=" + nickname
				+ "]";
	}

}
