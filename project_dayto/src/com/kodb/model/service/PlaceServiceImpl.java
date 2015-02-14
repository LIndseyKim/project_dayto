package com.kodb.model.service;

import java.util.HashMap;
import java.util.List;

import com.kodb.model.dao.PlaceDao;
import com.kodb.model.vo.Place;
import com.kodb.model.vo.User;

public class PlaceServiceImpl implements PlaceService {
	
	/*private UserDao userDao = new UserDao(); //이거는 나쁜 코드임!! new를 하다니!!
*/	private PlaceDao placeDao;
	
	
	public void setPlaceDao(PlaceDao placeDao) {
		this.placeDao = placeDao;
	}
	
	@Override
	public Place getPlace(String placeName){
		System.out.println("[getPlace_name]");
		// 아이디에 일치하는 회원정보 조회 : select
		return placeDao.selectPlace(placeName);
	}
	
	@Override
	public List<Place> getPlacesByAddr(String addr){
		System.out.println("[getPlace_byAddr]");
		return placeDao.selectPlacesByAddr(addr);
	}
}