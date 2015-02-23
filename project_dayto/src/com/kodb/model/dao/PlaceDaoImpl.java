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
}
