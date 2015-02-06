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
	public User selectUser(String userId) {

		return session.selectOne("user.selectUser", userId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kodb.model.dao.UserDao#selectUser(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public boolean selectUser(String userId, String pwd) {

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("password", pwd);

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
	public void deleteUser(String userId) {

		boolean flag = false;

		flag = session.insert("user.deleteUser", userId) > 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kodb.model.dao.UserDao#updateUser(com.kodb.model.vo.User)
	 */
	@Override
	public void updateUser(User user) {

		boolean flag = false;

		flag = session.insert("user.updateUser", user) > 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kodb.model.dao.UserDao#selectUsersByName(java.lang.String)
	 */
	@Override
	public List<User> selectUsersByName(String name) {

		return session.selectList("user.selectUsersByName", name);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kodb.model.dao.UserDao#selectUserByEmail(java.lang.String)
	 */
	@Override
	public User selectUserByEmail(String email) {

		return session.selectOne("user.selectUserByEmail", email);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kodb.model.dao.UserDao#selectUsersByIdOrEmail(java.util.Map)
	 */
	@Override
	public List<User> selectUsersByIdOrEmail(Map<String, Object> conditions) {

		return session.selectList("user.selectUsersByIdOrEmail", conditions);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kodb.model.dao.UserDao#selectUsersByIds(java.util.List)
	 */
	@Override
	public List<User> selectUsersByIds(List<String> ids) {

		return session.selectList("user.selectUsersByIds", ids);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kodb.model.dao.UserDao#selectUserWithContactListById(java.lang.String
	 * )
	 */
	@Override
	public User selectUserWithContactListById(String userId) {

		return session.selectOne("user.selectUserWithContactListById", userId);

	}
}
