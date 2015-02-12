package com.kodb.model.service;

import java.util.List;

import com.kodb.model.dao.UserDao;
import com.kodb.model.vo.Board;

public interface BoardService {
	


	public abstract void registerBoard(Board board);

	public abstract List<Board> getPostName(String user_email);


}
