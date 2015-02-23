package com.kodb.model.vo;

import java.sql.Date;
import java.util.ArrayList;

public class Blog {
	private int postId;
	private String userEmail;
	private String postName;
	private String postContent;
	private String postDate;
	private ArrayList<Picture> pictureList;
	
	public Blog() {
		super();
	}
	
	public Blog(int postId, String postName, String postContent, String postDate, String userEmail,
			ArrayList<Picture> pictureList) {
		super();
		this.postId = postId;
		this.userEmail = userEmail;
		this.postName = postName;
		this.postContent = postContent;
		this.postDate = postDate;
		this.pictureList = pictureList;
		
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		
		this.postId = postId;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public ArrayList<Picture> getPictureList() {
		return pictureList;
	}

	public void setPictureList(ArrayList<Picture> pictureList) {
		this.pictureList = pictureList;
	}

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	@Override
	public String toString() {
		return "Blog [postId=" + postId + ", postName=" + postName
				+ ", postDate ="+ postDate + "postContent=" + postContent + ", pictureList="
				+ pictureList + "]";
	}
}