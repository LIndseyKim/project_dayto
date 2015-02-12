package com.kodb.model.service;

import com.kodb.model.dao.BoardDao;
import com.kodb.model.vo.Board;

public class BoardServiceImpl implements BoardService{
	
	private BoardDao boardDao;	
	
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	@Override
	public void registerBoard(Board board){
		System.out.println(board.getUserEmail());
		System.out.println("[registerBoard]");
		// 아이디에 일치하는 회원정보 조회 : select
//		Board boardContents = boardDao.selectUser(board.getUserEmail());
		// 회원이 없다면 회원정보 저장 : insert
			boardDao.insertBoard(board);
		}

	
	
	@Override
	public Board getPostName(String userEmail) {
			System.out.println("[getPostName]");

			return boardDao.selectPostName(userEmail);
	}

	
	}
		

	

