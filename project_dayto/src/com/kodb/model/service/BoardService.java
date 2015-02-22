package com.kodb.model.service;

import java.util.List;

import com.kodb.model.vo.Blog;
import com.kodb.model.vo.Board;

public interface BoardService {
	
	public abstract void registerBoard(Board board);
	
	public abstract Board selectBoard(String userEmail);
	
	public abstract void registerPicture(int postId, String postPic);
	
	public abstract List<Board> getPostName(String userEmail);
	
	public abstract List<Blog> getPostWithPicture(String userEmail);
	
	public abstract Blog getPost(int postId);
	
	public abstract List<Blog> getAllPublicPost();
	
	public abstract List<Blog> getSearchPublicPost(String searchValue);
	
	public abstract Blog deletePost(int postId);

	public abstract void registerBoardById(Board board);

	public abstract void updatePicture(int postId, String postPic);
}







