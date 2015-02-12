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
		return placeDao.selectPlacesByAddr(addr);
	}
	
	// 회원 전체 리스트 조회하여 리턴
	/* (non-Javadoc)
	 * @see com.kodb.model.service.UserService#getAllUser()
	 */
	/*@Override
	public List<Place> getAllPlace(){
		System.out.println("[getAllPlace]");

		return placeDao;
	}*/
	/*
	// 로그인 성공시 true, 로그인 실패시 false 리턴
	 (non-Javadoc)
	 * @see com.kodb.model.service.UserService#login(java.lang.String, java.lang.String)
	 
	@Override
	public boolean login(String user_email,String user_pwd){
		System.out.println("[login]");
		
		 return placeDao.selectUser(user_email, user_pwd); 
	}
	
	 (non-Javadoc)
	 * @see com.kodb.model.service.UserService#getUsersByName(java.lang.String)
	 
	@Override
	public List<User> getUsersByName(String user_name){
		return userDao.selectUsersByName(user_name);
	}
	
	 (non-Javadoc)
	 * @see com.kodb.model.service.UserService#getUsersByIdOrEmail(java.lang.String, java.lang.String)
	 
	@Override
	public List<User> getUsersByEmail(String user_email){
		
		HashMap<String,Object> conditions
		  = new HashMap<String,Object>();
		
		if(user_email != null && user_email.trim().length() > 0){
			conditions.put("userId", user_email);
		}
		return userDao.selectUsersByEmail(conditions);
	}
	
	// 조건으로 오는 id 목록을 이용하여 해당id의 사용자 모두 조회
	 (non-Javadoc)
	 * @see com.kodb.model.service.UserService#getUsersByIds(java.util.List)
	 
	@Override
	public List<User> getUsersByEmails(List<String> emails){
		return userDao.selectUsersByEmails(emails);
	}
	
	 (non-Javadoc)
	 * @see com.kodb.model.service.UserService#getUserWithContactListById(java.lang.String)
	 
	@Override
	public User getUserWithContactListByEmail(String user_email){
		return userDao.selectUserWithContactListByEmail(user_email);
	}*/
}