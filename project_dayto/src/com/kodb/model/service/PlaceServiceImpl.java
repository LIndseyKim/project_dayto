package com.kodb.model.service;

import java.util.HashMap;
import java.util.List;

import com.kodb.model.dao.PlaceDao;
import com.kodb.model.vo.Place;
import com.kodb.model.vo.User;

public class PlaceServiceImpl implements PlaceService {
	
	/*private UserDao userDao = new UserDao(); //�̰Ŵ� ���� �ڵ���!! new�� �ϴٴ�!!
*/	private PlaceDao placeDao;
	
	
	public void setPlaceDao(PlaceDao placeDao) {
		this.placeDao = placeDao;
	}

	@Override
	public Place getPlace(String placeName){
		System.out.println("[getPlace_name]");
		// ���̵� ��ġ�ϴ� ȸ������ ��ȸ : select
		return placeDao.selectPlace(placeName);
	}
	
	// ȸ�� ��ü ����Ʈ ��ȸ�Ͽ� ����
	/* (non-Javadoc)
	 * @see com.kodb.model.service.UserService#getAllUser()
	 */
	/*@Override
	public List<User> getAllUser(){
		System.out.println("[getAllUser]");

		return placeDao.selectUser();
	}
	
	// �α��� ������ true, �α��� ���н� false ����
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
	
	// �������� ���� id ����� �̿��Ͽ� �ش�id�� ����� ��� ��ȸ
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