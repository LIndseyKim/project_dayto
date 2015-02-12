package com.kodb.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kodb.model.vo.User;

public class UserDaoImpl implements UserDao {
	SqlSession session;

	public void setSession(SqlSession session) {
		this.session = session;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kodb.model.dao.UserDao#selectUser(java.lang.String)
	 */
	@Override
	public User selectUser(String userEmail) {
		return session.selectOne("user.selectUser", userEmail);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kodb.model.dao.UserDao#selectUser(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public boolean selectUser(String userEmail, String userPwd) {

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("userEmail", userEmail);
		map.put("userPwd", userPwd);

		if (session.selectOne("user.login", map) != null) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kodb.model.dao.UserDao#selectUser()
	 */
	@Override
	public List<User> selectUser() {
		return session.selectList("user.selectAllUser");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kodb.model.dao.UserDao#insertUser(com.kodb.model.vo.User)
	 */
	@Override
	public void insertUser(User user) {

		boolean flag = false;

		flag = session.insert("user.insertUser", user) > 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kodb.model.dao.UserDao#deleteUser(java.lang.String)
	 */
	@Override
	public void deleteUser(String userEmail) {

		boolean flag = false;

		flag = session.insert("user.deleteUser", userEmail) > 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kodb.model.dao.UserDao#updateUser(com.kodb.model.vo.User)
	 */
	@Override
	public void updateUser(User user) {

		boolean flag = false;
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("userEmail", user.getUserEmail());
		map.put("userPwd", user.getUserPwd());
		map.put("userPic", user.getUserPic());
		map.put("userProfile", user.getUserProfile());

		flag = session.insert("user.updateUser", map) > 0;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kodb.model.dao.UserDao#selectUsersByName(java.lang.String)
	 */
	@Override
	public List<User> selectUsersByName(String userName) {

		return session.selectList("user.selectUsersByName", userName);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kodb.model.dao.UserDao#selectUsersByIdOrEmail(java.util.Map)
	 */
	@Override
	public List<User> selectUsersByEmail(Map<String, Object> conditions) {

		return session.selectList("user.selectUsersByEmail", conditions);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kodb.model.dao.UserDao#selectUsersByIds(java.util.List)
	 */
	@Override
	public List<User> selectUsersByEmails(List<String> emails) {

		return session.selectList("user.selectUsersByEmails", emails);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kodb.model.dao.UserDao#selectUserWithContactListById(java.lang.String
	 * )
	 */
	@Override
	public User selectUserWithContactListByEmail(String userEmail) {

		return session.selectOne("user.selectUserWithContactListByEmail", userEmail);

	}
}
