package com.kodb.model.service;

import java.util.List;

import com.kodb.model.vo.Place;
import com.kodb.model.vo.User;

public interface PlaceService {

	public abstract Place getPlace(String placeName);
	public abstract List<Place> getPlacesByAddr(String addr);


	// 회원 전체 리스트 조회하여 리턴
	//public abstract List<Place> getAllPlace();
	/*
	// 로그인 성공시 true, 로그인 실패시 false 리턴
	public abstract boolean login(String user_email, String user_pwd);

	public abstract List<User> getUsersByName(String user_name);

	public abstract List<User> getUsersByEmail(String user_email);

	// 조건으로 오는 id 목록을 이용하여 해당id의 사용자 모두 조회
	public abstract List<User> getUsersByEmails(List<String> emails);

	public abstract User getUserWithContactListByEmail(String user_email);
*/
}