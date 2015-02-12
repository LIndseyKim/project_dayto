package com.kodb.model.service;

import java.util.HashMap;
import java.util.List;

import com.kodb.model.dao.UserDao;
import com.kodb.model.vo.User;

public class UserServiceImpl implements UserService {
	
	/*private UserDao userDao = new UserDao(); //�̰Ŵ� ���� �ڵ���!! new�� �ϴٴ�!!
*/	private UserDao userDao;
	
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/* (non-Javadoc)
	 * @see com.kodb.model.service.UserService#registerUser(com.kodb.model.vo.User)
	 */
	@Override
	public void registerUser(User user){
		
		System.out.println("[registerUser]");
		// ���̵� ��ġ�ϴ� ȸ������ ��ȸ : select
		User member = userDao.selectUser(user.getUser_email());
		// ȸ���� ���ٸ� ȸ������ ���� : insert
		if(member == null){
			userDao.insertUser(user);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.kodb.model.service.UserService#getUser(java.lang.String)
	 */
	@Override
	public User getUser(String user_email){
		System.out.println("[getUser_email]");
		// ���̵� ��ġ�ϴ� ȸ������ ��ȸ : select
		return userDao.selectUser(user_email);
	}
	
	// ���̵� ��ġ�ϴ� ȸ�� ����
	/* (non-Javadoc)
	 * @see com.kodb.model.service.UserService#removeUser(java.lang.String)
	 */
	@Override
	public void removeUser(String user_email){
		System.out.println("[removeUser]");
		User member = userDao.selectUser(user_email);
		if(member != null){
			userDao.deleteUser(user_email);
		} else{
			System.out.println(user_email + " ȸ���� �������� �ʽ��ϴ�.");
		}
	}
	
	// ���̵� �ش��ϴ� ȸ������ ����
	/* (non-Javadoc)
	 * @see com.kodb.model.service.UserService#modifyUser(com.kodb.model.vo.User)
	 */
	@Override
	public void modifyUser(User user){
		System.out.println("[modifyUser]");
		
		User member = userDao.selectUser(user.getUser_email());
		if(member != null){
			userDao.updateUser(user);
		} else{
			System.out.println(user.getUser_email() + " ȸ���� �������� �ʽ��ϴ�.");
		}
	}
	
	// ȸ�� ��ü ����Ʈ ��ȸ�Ͽ� ����
	/* (non-Javadoc)
	 * @see com.kodb.model.service.UserService#getAllUser()
	 */
	@Override
	public List<User> getAllUser(){
		System.out.println("[getAllUser]");

		return userDao.selectUser();
	}
	
	// �α��� ������ true, �α��� ���н� false ����
	/* (non-Javadoc)
	 * @see com.kodb.model.service.UserService#login(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean login(String user_email,String user_pwd){
		System.out.println("[login]");
		
		 return userDao.selectUser(user_email, user_pwd); 
	}
	
	/* (non-Javadoc)
	 * @see com.kodb.model.service.UserService#getUsersByName(java.lang.String)
	 */
	@Override
	public List<User> getUsersByName(String user_name){
		return userDao.selectUsersByName(user_name);
	}
	
	/* (non-Javadoc)
	 * @see com.kodb.model.service.UserService#getUsersByIdOrEmail(java.lang.String, java.lang.String)
	 */
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

	@Override
	public List<User> getUsersByEmails(List<String> emails){
		return userDao.selectUsersByEmails(emails);
	}
	

	@Override
	public User getUserWithContactListByEmail(String user_email){
		return userDao.selectUserWithContactListByEmail(user_email);
	}
}