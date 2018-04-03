package com.esri.bean;

import java.sql.Time;

public class CommentPhoto {
	private String cID;
	private Time commentTime;
	private String content;
	private String replyID;

	public CommentPhoto(String cID, Time commentTime, String content, String replyID) {
		super();
		this.cID = cID;
		this.commentTime = commentTime;
		this.content = content;
		this.replyID = replyID;
	}

	@Override
	public String toString() {
		return "CommentPhoto [cID=" + cID + ", commentTime=" + commentTime + ", content=" + content + ", replyID="
				+ replyID + "]";
	}

	public String getcID() {
		return cID;
	}

	public void setcID(String cID) {
		this.cID = cID;
	}

	public Time getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(Time commentTime) {
		this.commentTime = commentTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReplyID() {
		return replyID;
	}

	public void setReplyID(String replyID) {
		this.replyID = replyID;
	}

}
