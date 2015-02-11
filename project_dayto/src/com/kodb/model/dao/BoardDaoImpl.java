package com.kodb.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kodb.model.vo.Board;

public class BoardDaoImpl  implements BoardDao {

	SqlSession session;

	public void setSession(SqlSession session) {
		this.session = session;
	}

	@Override
	public void insertBoard(Board board) {

		boolean flag = false;

		flag = session.insert("board.insertBoard", board) > 0;
	}

	@Override
	public Board selectUser(String userEmail) {
		boolean flag = false;			
		
		// TODO Auto-generated method stub
		return session.selectOne("board.selectBoard", userEmail);
		
	}
	
	
	
}
