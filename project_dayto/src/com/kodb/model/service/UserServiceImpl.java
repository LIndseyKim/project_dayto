package com.kodb.model.service;

import java.util.HashMap;
import java.util.List;

import com.kodb.model.dao.UserDao;
import com.kodb.model.vo.User;

public class UserServiceImpl implements UserService {
	
	/*private UserDao userDao = new UserDao(); //이거는 나쁜 코드임!! new를 하다니!!*/
	private UserDao userDao;
	
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/* (non-Javadoc)
	 * @see com.kodb.model.service.UserService#registerUser(com.kodb.model.vo.User)
	 */
	@Override
	public void registerUser(User user){
		
		System.out.println("[registerUser]");
		// 아이디에 일치하는 회원정보 조회 : select
		User member = userDao.selectUser(user.getUserEmail());
		// 회원이 없다면 회원정보 저장 : insert
		if(member == null){
			userDao.insertUser(user);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.kodb.model.service.UserService#getUser(java.lang.String)
	 */
	@Override
	public User getUser(String userEmail){
		System.out.println("[getUserEmail]");
		// 아이디에 일치하는 회원정보 조회 : select
		return userDao.selectUser(userEmail);
	}
	
	// 아이디에 일치하는 회원 삭제
	/* (non-Javadoc)
	 * @see com.kodb.model.service.UserService#removeUser(java.lang.String)
	 */
	@Override
	public void removeUser(String userEmail){
		System.out.println("[removeUser]");
		User member = userDao.selectUser(userEmail);
		if(member != null){
			userDao.deleteUser(userEmail);
		} else{
			System.out.println(userEmail + " 회원은 존재하지 않습니다.");
		}
	}
	
	// 아이디에 해당하는 회원정보 수정
	/* (non-Javadoc)
	 * @see com.kodb.model.service.UserService#modifyUser(com.kodb.model.vo.User)
	 */
	@Override
	public void modifyUser(User user){
		System.out.println("[modifyUser]");
		
		userDao.updateUser(user);
		/*User member = userDao.selectUser(user.getUserEmail());
		if(member != null){
			userDao.updateUser(user);
		} else{
			System.out.println(user.getUserEmail() + " 회원은 존재하지 않습니다.");
		}*/
	}

	// 회원 전체 리스트 조회하여 리턴
	/* (non-Javadoc)
	 * @see com.kodb.model.service.UserService#getAllUser()
	 */
	@Override
	public List<User> getAllUser(){
		System.out.println("[getAllUser]");

		return userDao.selectUser();
	}
	
	// 로그인 성공시 true, 로그인 실패시 false 리턴
	/* (non-Javadoc)
	 * @see com.kodb.model.service.UserService#login(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean login(String userEmail,String userPwd){
		System.out.println("[login]");
		
		 return userDao.selectUser(userEmail, userPwd); 
	}
	
	/* (non-Javadoc)
	 * @see com.kodb.model.service.UserService#getUsersByName(java.lang.String)
	 */
	@Override
	public List<User> getUsersByName(String userName){
		return userDao.selectUsersByName(userName);
	}
	
	/* (non-Javadoc)
	 * @see com.kodb.model.service.UserService#getUsersByIdOrEmail(java.lang.String, java.lang.String)
	 */
	@Override
	public List<User> getUsersByEmail(String userEmail){
		
		HashMap<String,Object> conditions
		  = new HashMap<String,Object>();
		
		if(userEmail != null && userEmail.trim().length() > 0){
			conditions.put("userId", userEmail);
		}
		return userDao.selectUsersByEmail(conditions);
	}
	
	// 조건으로 오는 id 목록을 이용하여 해당id의 사용자 모두 조회
	/* (non-Javadoc)
	 * @see com.kodb.model.service.UserService#getUsersByIds(java.util.List)
	 */
	@Override
	public List<User> getUsersByEmails(List<String> emails){
		return userDao.selectUsersByEmails(emails);
	}
	
	/* (non-Javadoc)
	 * @see com.kodb.model.service.UserService#getUserWithContactListById(java.lang.String)
	 */
	@Override
	public User getUserWithContactListByEmail(String userEmail){
		return userDao.selectUserWithContactListByEmail(userEmail);
	}
}