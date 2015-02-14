package com.kodb.model.service;

import java.util.List;

import com.kodb.model.dao.UserDao;
import com.kodb.model.vo.Blog;
import com.kodb.model.vo.Board;

public interface BoardService {
	
	public abstract void registerBoard(Board board);
	
	public abstract Board selectBoard(String userEmail);
	
	public abstract void registerPicture(int postId, String postPic);
	
	public abstract List<Board> getPostName(String userEmail);
	
	public abstract List<Blog> getPostWithPicture(String userEmail);
}
