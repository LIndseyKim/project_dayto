package com.kodb.model.dao;

import com.kodb.model.vo.Board;

public interface  BoardDao {

	public abstract void insertBoard(Board board);

	public abstract Board selectUser(String user_email);

}
