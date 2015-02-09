package com.kodb.model.dao;

import java.util.List;
import java.util.Map;

import com.kodb.model.vo.User;

public interface UserDao {

	public abstract User selectUser(String user_email);

	public abstract boolean selectUser(String user_email, String user_pwd);

	public abstract List<User> selectUser();

	public abstract void insertUser(User user);

	public abstract void deleteUser(String user_email);

	public abstract void updateUser(User user);

	public abstract List<User> selectUsersByName(String user_name);

	public abstract List<User> selectUsersByEmail(
			Map<String, Object> conditions);

	public abstract List<User> selectUsersByEmails(List<String> emails);

	public abstract User selectUserWithContactListByEmail(String user_email);

}