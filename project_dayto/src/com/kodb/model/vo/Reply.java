package com.kodb.model.vo;

import java.util.Date;

public class Reply {
	
	int replyId ;	
	int placeId ;
	String userEmail;
	String replyContent ;
	
	
	
	
	public Reply() {
		super();
	}
	@Override
	public String toString() {
		return "Reply [replyId=" + replyId + ", placeId=" + placeId
				+ ", userEmail=" + userEmail + ", replyContent=" + replyContent
				+ ", replyDate=" + replyDate + ", getReplyId()=" + getReplyId()
				+ ", getPlaceId()=" + getPlaceId() + ", getUserEmail()="
				+ getUserEmail() + ", getReplyContent()=" + getReplyContent()
				+ ", getReplyDate()=" + getReplyDate() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}
	public int getPlaceId() {
		return placeId;
	}
	public void setPlaceId(int placeId) {
		this.placeId = placeId;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public Date getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}
	Date replyDate ;
	
	
	

}
