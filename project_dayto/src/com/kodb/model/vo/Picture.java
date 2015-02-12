package com.kodb.model.vo;

public class Picture {

	private int blogPicId;
	private int postId; 
	private String postPic;
	
	public Picture() {
		super();
	}
	public Picture(int blogPicId, int postId, String postPic) {
		super();
		this.blogPicId = blogPicId;
		this.postId = postId;
		this.postPic = postPic;
	}
	public int getBlogPicId() {
		return blogPicId;
	}
	public int getPostId() {
		return postId;
	}
	public String getPostPic() {
		return postPic;
	}
	@Override
	public String toString() {
		return "Picture [blogPicId=" + blogPicId + ", postId=" + postId
				+ ", postPic=" + postPic + "]";
	}
}
