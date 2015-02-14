package com.kodb.model.vo;

import java.util.ArrayList;

public class Blog {
	private int postId;
	private String postName;
	private ArrayList<Picture> pictureList;
	
	public Blog() {
		super();
	}

	public Blog(int postId, String postName) {
		super();
		this.postId = postId;
		this.postName = postName;
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

	public ArrayList<Picture> getPictureList() {
		return pictureList;
	}

	public void setPictureList(ArrayList<Picture> pictureList) {
		this.pictureList = pictureList;
	}

	@Override
	public String toString() {
		return "Blog [postId=" + postId + ", postName=" + postName
				+ ", pictureList=" + pictureList + "]";
	}
}