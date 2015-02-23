package com.kodb.model.dao;

import java.util.List;

import com.kodb.model.vo.Blog;
import com.kodb.model.vo.Board;
import com.kodb.model.vo.User;

public interface  BoardDao {

	public abstract void insertBoard(Board board);

	public abstract Board selectBoard(String userEmail);

	public abstract List<Board> selectPostName(String userEmail);
	
	public abstract void insertBoardImages(int postId, String picturePath);
	
	public abstract List<Blog> selectPostWithPicture(String userEmail);
	
	public abstract Blog selectPost(int postId);
	
	public abstract List<Blog> selectAllPulicPost();
	
	public abstract List<Blog> selectSearchPost(String searchValue);

	public abstract Blog deletePost(int postId);

	public abstract void updateBoard(Board board);

	public abstract void updateBoardImages(int postId, String picturePath);

	public abstract Blog selectPostDate(String postDate);
	
}
