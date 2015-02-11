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
		// ���̵� ��ġ�ϴ� ȸ������ ��ȸ : select
//		Board boardContents = boardDao.selectUser(board.getUserEmail());
		// ȸ���� ���ٸ� ȸ������ ���� : insert
			boardDao.insertBoard(board);
		}

	
	}
		

	

