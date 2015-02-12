package com.kodb.model.vo;

import java.util.Date;

public class Board {

	private int postId;
	private String userEmail;
	private String postName;
	private Date postDate;
	private String postContent;
	private String postRecomm;
	private String postPublic;

	public void setPostPublic(String postPublic) {
		this.postPublic = postPublic;
	}

	@Override
	public String toString() {
		return "Board [postId=" + postId + ", userEmail=" + userEmail
				+ ", postName=" + postName + ", postDate=" + postDate
				+ ", postContent=" + postContent + ", postRecomm=" + postRecomm
				+ ", postPublic=" + postPublic + "]";
	}

	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public String getPostRecomm() {
		return postRecomm;
	}
	public void setPostRecomm(String postRecomm) {
		this.postRecomm = postRecomm;
	}

	public String getPostPublic() {
		return postPublic;
	}
}
