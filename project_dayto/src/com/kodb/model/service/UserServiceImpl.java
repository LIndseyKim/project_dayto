package com.kodb.model.service;

import java.util.HashMap;
import java.util.List;

import com.kodb.model.dao.UserDao;
import com.kodb.model.vo.User;

public class UserServiceImpl implements UserService {
	
	/*private UserDao userDao = new UserDao(); //�̰Ŵ� ���� �ڵ���!! new�� �ϴٴ�!!
*/	private UserDao userDao; //�̰Ŵ� ���� �ڵ���!! new�� �ϴٴ�!!
	
	
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
		User member = userDao.selectUser(user.getUserId());
		// ȸ���� ���ٸ� ȸ������ ���� : insert
		if(member == null){
			userDao.insertUser(user);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.kodb.model.service.UserService#getUser(java.lang.String)
	 */
	@Override
	public User getUser(String userId){
		System.out.println("[getUser]");
		// ���̵� ��ġ�ϴ� ȸ������ ��ȸ : select
		return userDao.selectUser(userId);
	}
	
	// ���̵� ��ġ�ϴ� ȸ�� ����
	/* (non-Javadoc)
	 * @see com.kodb.model.service.UserService#removeUser(java.lang.String)
	 */
	@Override
	public void removeUser(String userId){
		System.out.println("[removeUser]");
		User member = userDao.selectUser(userId);
		if(member != null){
			userDao.deleteUser(userId);
		} else{
			System.out.println(userId + " ȸ���� �������� �ʽ��ϴ�.");
		}
	}
	
	// ���̵� �ش��ϴ� ȸ������ ����
	/* (non-Javadoc)
	 * @see com.kodb.model.service.UserService#modifyUser(com.kodb.model.vo.User)
	 */
	@Override
	public void modifyUser(User user){
		System.out.println("[modifyUser]");
		
		User member = userDao.selectUser(user.getUserId());
		if(member != null){
			userDao.updateUser(user);
		} else{
			System.out.println(user.getUserId() + " ȸ���� �������� �ʽ��ϴ�.");
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
	public boolean login(String userId,String password){
		System.out.println("[login]");
		
		 return userDao.selectUser(userId, password); 
	}
	
	/* (non-Javadoc)
	 * @see com.kodb.model.service.UserService#getUsersByName(java.lang.String)
	 */
	@Override
	public List<User> getUsersByName(String name){
		return userDao.selectUsersByName(name);
	}
	
	/* (non-Javadoc)
	 * @see com.kodb.model.service.UserService#getUserByEmail(java.lang.String)
	 */
	@Override
	public User getUserByEmail(String email){
		return userDao.selectUserByEmail(email);
	}
	
	/* (non-Javadoc)
	 * @see com.kodb.model.service.UserService#getUsersByIdOrEmail(java.lang.String, java.lang.String)
	 */
	@Override
	public List<User> getUsersByIdOrEmail(String userId,String email){
		
		HashMap<String,Object> conditions
		  = new HashMap<String,Object>();
		
		if(userId != null && userId.trim().length() > 0){
			conditions.put("userId", userId);
		}

		if(email != null && email.trim().length() > 0){
			conditions.put("email", email);
		}
		
		return userDao.selectUsersByIdOrEmail(conditions);
	}
	
	// �������� ���� id ����� �̿��Ͽ� �ش�id�� ����� ��� ��ȸ
	/* (non-Javadoc)
	 * @see com.kodb.model.service.UserService#getUsersByIds(java.util.List)
	 */
	@Override
	public List<User> getUsersByIds(List<String> ids){
		return userDao.selectUsersByIds(ids);
	}
	
	/* (non-Javadoc)
	 * @see com.kodb.model.service.UserService#getUserWithContactListById(java.lang.String)
	 */
	@Override
	public User getUserWithContactListById(String userId){
		return userDao.selectUserWithContactListById(userId);
	}
	
}
















