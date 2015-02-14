package com.kodb.model.service;

import java.util.List;

import com.kodb.model.dao.BoardDao;
import com.kodb.model.vo.Blog;
import com.kodb.model.vo.Board;

public class BoardServiceImpl implements BoardService{
	
	private BoardDao boardDao;	
	
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	@Override
	public void registerBoard(Board board){
		System.out.println("[registerBoard]");
		// 아이디에 일치하는 회원정보 조회 : select
//		Board boardContents = boardDao.selectUser(board.getUserEmail());
		// 회원이 없다면 회원정보 저장 : insert
			boardDao.insertBoard(board);
		}

	@Override
	public Board selectBoard(String userEmail) {
		System.out.println("[selectBoard]");
		return boardDao.selectBoard(userEmail);
	}
	
	@Override
	public void registerPicture(int postId, String postPic) {
		System.out.println("[registerPicture]");
		boardDao.insertBoardImages(postId, postPic);
	}
	
	@Override
	public List<Board> getPostName(String userEmail) {
			System.out.println("[getPostName]");
			
			return boardDao.selectPostName(userEmail);
	}
	
	@Override
	public List<Blog> getPostWithPicture(String userEmail) {
		System.out.println("[getPostWithPicture]");
		return boardDao.selectPostWithPicture(userEmail);
	}
	
	@Override
	public Blog getPost(int postId) {
		System.out.println("[getPost]");
		return boardDao.selectPost(postId);
	}
	
}