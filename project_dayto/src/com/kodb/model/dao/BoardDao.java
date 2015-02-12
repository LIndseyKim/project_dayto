package com.kodb.model.dao;

import java.util.List;

import com.kodb.model.vo.Board;
import com.kodb.model.vo.User;

public interface  BoardDao {

	public abstract void insertBoard(Board board);

	public abstract Board selectUser(String userEmail);

	public abstract List<Board> selectPostName(String userEmail); 
	
}
