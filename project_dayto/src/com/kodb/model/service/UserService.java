package com.kodb.model.service;

import java.util.List;

import com.kodb.model.vo.User;

public interface UserService {

	public abstract void registerUser(User user);

	public abstract User getUser(String userEmail);

	// 아이디에 일치하는 회원 삭제
	public abstract void removeUser(String userEmail);

	// 아이디에 해당하는 회원정보 수정
	public abstract void modifyUser(User user);
	
	// 회원 전체 리스트 조회하여 리턴
	public abstract List<User> getAllUser();

	// 로그인 성공시 true, 로그인 실패시 false 리턴
	public abstract boolean login(String userEmail, String userPwd);

	public abstract List<User> getUsersByName(String userName);

	public abstract List<User> getUsersByEmail(String userEmail);

	// 조건으로 오는 id 목록을 이용하여 해당id의 사용자 모두 조회
	public abstract List<User> getUsersByEmails(List<String> emails);

	public abstract User getUserWithContactListByEmail(String userEmail);

}