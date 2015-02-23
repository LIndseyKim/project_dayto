
package com.kodb.model.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kodb.model.vo.Blog;
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
	public void updateBoard(Board board) {
		boolean flag = false;
		flag = session.insert("board.updateBoard", board) > 0;
	}

	@Override
	public Board selectBoard(String userEmail) {
		boolean flag = false;			
		// TODO Auto-generated method stub
		return session.selectOne("board.selectBoard", userEmail);
		
	}

	@Override
	public List<Board>  selectPostName(String userEmail) {
		boolean flag = false;
		
		return session.selectList("board.selectPostName", userEmail);
		
	}
	
	@Override
	public void insertBoardImages(int postId, String postPic) {

		boolean flag = false;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("postId", postId);
		map.put("postPic", postPic);
		flag = session.insert("picture.insertPic", map) > 0;
	}
	
	@Override
	public void updateBoardImages(int postId, String postPic) {
		boolean flag = false;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("postId", postId);
		map.put("postPic", postPic);
		flag = session.insert("picture.updatePic", map) > 0;
	}
	
	@Override
	public List<Blog> selectPostWithPicture(String userEmail) {
		return session.selectList("board.selectPostWithPicture", userEmail);
	}
	
	@Override
	public Blog selectPost(int postId) {
		return session.selectOne("board.selectPost", postId);
	}
	
	@Override
	public List<Blog>  selectAllPulicPost() {

		return session.selectList("board.selectPublicBlog");
		
	}
	
	@Override
	public List<Blog> selectSearchPost(String searchValue) {
		return session.selectList("board.selectSearchBlog",searchValue);
	}
	
	@Override
	public Blog deletePost(int postId) {

		//int flag = false;

		//flag = session.insert("user.deleteUser", userEmail) > 0;
		return session.selectOne("board.deletePost", postId);
	}



	
}
