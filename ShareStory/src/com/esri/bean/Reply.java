package com.esri.bean;

import java.sql.Time;

public class Reply {
	
	private Time replyTime;
	private String replyContent;
	private String userID;
	private String commentID;
	
	
	public Time getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(Time replyTime) {
		this.replyTime = replyTime;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getCommentID() {
		return commentID;
	}
	public void setCommentID(String commentID) {
		this.commentID = commentID;
	}
	@Override
	public String toString() {
		return "Reply [replyTime=" + replyTime + ", replyContent=" + replyContent + ", userID=" + userID
				+ ", commentID=" + commentID + "]";
	}

	
}
