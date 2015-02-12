package com.kodb.model.service;

import com.kodb.model.vo.Board;

public interface BoardService {

	public abstract void registerBoard(Board board);

	public abstract Board getPostName(String user_email);


}
