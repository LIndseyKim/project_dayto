package com.kodb.model.dao;

import java.util.List;
import java.util.Map;

import com.kodb.model.vo.User;

public interface UserDao {

	public abstract User selectUser(String userEmail);

	public abstract boolean selectUser(String userEmail, String userPwd);

	public abstract List<User> selectUser();

	public abstract void insertUser(User user);

	public abstract void deleteUser(String userEmail);

	public abstract void updateUser(User user);

	public abstract List<User> selectUsersByName(String userName);

	public abstract List<User> selectUsersByEmail(
			Map<String, Object> conditions);

	public abstract List<User> selectUsersByEmails(List<String> emails);

	public abstract User selectUserWithContactListByEmail(String userEmail);

}