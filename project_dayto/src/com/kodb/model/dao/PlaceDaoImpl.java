package com.kodb.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kodb.model.vo.Place;
import com.kodb.model.vo.User;

public class PlaceDaoImpl implements PlaceDao {
	SqlSession session;

	public void setSession(SqlSession session) {
		this.session = session;
	}

	@Override
	public Place selectPlace(String placeName) {
		return session.selectOne("place.selectPlace", placeName);
	}
	@Override
	public List<Place> selectPlacesByAddr(String addr) {
		return session.selectList("place.selectPlacesByAddr", addr);
		
	}
	
	@Override
	public void updateRecomm(int placeId) {

		session.update("place.updateRecomm", placeId) ;
		
	}
	
/*	@Override
	public boolean selectPlace(String place_name) {

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("user_email", user_email);
		map.put("user_pwd", user_pwd);

		if (session.selectOne("user.login", map) != null) {
			return true;
		}
		return false;
	}*/



	/*@Override
	public List<User> selectUser() {
		return session.selectList("user.selectAllUser");
	}

	@Override
	public List<User> selectUsersByName(String user_name) {

		return session.selectList("user.selectUsersByName", user_name);

	}


	@Override
	public List<User> selectUsersByEmail(Map<String, Object> conditions) {

		return session.selectList("user.selectUsersByEmail", conditions);
	}

	@Override
	public List<User> selectUsersByEmails(List<String> emails) {

		return session.selectList("user.selectUsersByEmails", emails);
	}

	
	@Override
	public User selectUserWithContactListByEmail(String user_email) {

		return session.selectOne("user.selectUserWithContactListByEmail", user_email);

	}*/
}
