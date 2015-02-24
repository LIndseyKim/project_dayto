package com.kodb.model.service;

import java.util.HashMap;
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
		boardDao.insertBoard(board);
	}
	@Override
	public void registerBoardById(Board board) {
		System.out.println("[registerBoardById]");
		boardDao.updateBoard(board);

		
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
	
	/*  HashMap<String,Object> conditions
	  = new HashMap<String,Object>();
	
	if(userId != null && userId.trim().length() > 0){
		conditions.put("userId", userId);
	}

	if(email != null && email.trim().length() > 0){
		conditions.put("email", email);
	}  */
	
	
	@Override
	public void updatePicture(int postId, String postPic) {
		System.out.println("[updatePicture]");
		boardDao.updateBoardImages(postId, postPic);


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
	public Blog getPostDate(String postDate) {
		System.out.println("[getPostDate]");
		return boardDao.selectPostDate(postDate);
	}
	
	@Override
	public List<Blog> getAllPublicPost() {
		System.out.println("[getAllPublicPost]");
		return boardDao.selectAllPulicPost();
	}
	
	@Override
	public List<Blog> getSearchPublicPost(String searchValue) {
 		System.out.println("[getSearchPublicPost]");
		return boardDao.selectSearchPost(searchValue);
	}
	
	@Override
	public Blog deletePost(int postId) {
		System.out.println("[deletePost]");
		return boardDao.deletePost(postId);
	}

	@Override
	public void deletePicsById(int postId) {
		System.out.println("[deletePicsById]");
		boardDao.deletePicsById(postId);

	}

	@Override
	public Blog selectPostIdByPicId(int picId) {
		System.out.println("[selectPostIdByPicId]");
		System.out.println(picId+"Service");
		return boardDao.selectPostIdByPicId(picId);

	}
}
