package com.kodb.model.service;

import java.util.HashMap;
import java.util.List;

import com.kodb.model.dao.UserDao;
import com.kodb.model.vo.User;

public class UserServiceImpl implements UserService {
	
	/*private UserDao userDao = new UserDao(); //�̰Ŵ� ���� �ڵ���!! new�� �ϴٴ�!!*/
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
		// ���̵� ��ġ�ϴ� ȸ������ ��ȸ : select
		User member = userDao.selectUser(user.getUserEmail());
		// ȸ���� ���ٸ� ȸ������ ���� : insert
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
		// ���̵� ��ġ�ϴ� ȸ������ ��ȸ : select
		return userDao.selectUser(userEmail);
	}
	
	// ���̵� ��ġ�ϴ� ȸ�� ����
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
			System.out.println(userEmail + " ȸ���� �������� �ʽ��ϴ�.");
		}
	}
	
	// ���̵� �ش��ϴ� ȸ������ ����
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
			System.out.println(user.getUserEmail() + " ȸ���� �������� �ʽ��ϴ�.");
		}*/
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
	
	// �������� ���� id ����� �̿��Ͽ� �ش�id�� ����� ��� ��ȸ
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