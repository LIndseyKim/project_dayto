package com.kodb.model.dao;

import java.util.List;
import java.util.Map;

import com.kodb.model.vo.User;

public interface UserDao {

	public abstract User selectUser(String userId);

	public abstract boolean selectUser(String userId, String pwd);

	public abstract List<User> selectUser();

	public abstract void insertUser(User user);

	public abstract void deleteUser(String userId);

	public abstract void updateUser(User user);

	public abstract List<User> selectUsersByName(String name);

	public abstract User selectUserByEmail(String email);

	public abstract List<User> selectUsersByIdOrEmail(
			Map<String, Object> conditions);

	public abstract List<User> selectUsersByIds(List<String> ids);

	public abstract User selectUserWithContactListById(String userId);

}