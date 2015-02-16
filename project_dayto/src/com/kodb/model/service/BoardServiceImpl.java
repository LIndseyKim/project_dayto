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
		// ���̵� ��ġ�ϴ� ȸ������ ��ȸ : select
//		Board boardContents = boardDao.selectUser(board.getUserEmail());
		// ȸ���� ��ٸ� ȸ������ ���� : insert
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
	
	@Override
	public List<Board> getAllPublicPost() {
			System.out.println("[getAllPublicPost]");
			
			return boardDao.selectAllPulicPost();
	}
}