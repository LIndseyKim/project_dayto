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


	@Override
	public User selectUser(String user_email) {

		return session.selectOne("user.selectUser", user_email);
	}


	@Override
	public boolean selectUser(String user_email, String user_pwd) {

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("user_email", user_email);
		map.put("user_pwd", user_pwd);

		if (session.selectOne("user.login", map) != null) {
			return true;
		}
		return false;
	}


	@Override
	public List<User> selectUser() {
		return session.selectList("user.selectAllUser");
	}

	
	@Override
	public void insertUser(User user) {

		boolean flag = false;

		flag = session.insert("user.insertUser", user) > 0;
	}

	
	@Override
	public void deleteUser(String user_email) {

		boolean flag = false;

		flag = session.insert("user.deleteUser", user_email) > 0;
	}

	
	@Override
	public void updateUser(User user) {

		boolean flag = false;

		flag = session.insert("user.updateUser", user) > 0;
	}


	@Override
	public List<User> selectUsersByName(String user_name) {

		return session.selectList("user.selectUsersByName", user_name);

	}


	@Override
	public List<User> selectUsersByEmail(Map<String, Object> conditions) {

		return session.selectList("user.selectUsersByEmail", conditions);
	}

	
	@Override
	public List<User> selectUsersByEmails(List<String> emails) {

		return session.selectList("user.selectUsersByEmails", emails);
	}

	
	@Override
	public User selectUserWithContactListByEmail(String user_email) {

		return session.selectOne("user.selectUserWithContactListByEmail", user_email);

	}
}
