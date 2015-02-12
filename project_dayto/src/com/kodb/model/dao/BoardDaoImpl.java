
package com.kodb.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kodb.model.vo.Board;
import com.kodb.model.vo.User;

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

	@Override
	public List<Board>  selectPostName(String userEmail) {
		boolean flag = false;
		
		return session.selectList("board.selectPostName", userEmail);
		
	}
	
	
	
}