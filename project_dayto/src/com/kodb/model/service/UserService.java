package com.kodb.model.service;

import java.util.List;

import com.kodb.model.vo.User;

public interface UserService {

	public abstract void registerUser(User user);

	public abstract User getUser(String userId);

	// ���̵� ��ġ�ϴ� ȸ�� ����
	public abstract void removeUser(String userId);

	// ���̵� �ش��ϴ� ȸ������ ����
	public abstract void modifyUser(User user);

	// ȸ�� ��ü ����Ʈ ��ȸ�Ͽ� ����
	public abstract List<User> getAllUser();

	// �α��� ������ true, �α��� ���н� false ����
	public abstract boolean login(String userId, String password);

	public abstract List<User> getUsersByName(String name);

	public abstract User getUserByEmail(String email);

	public abstract List<User> getUsersByIdOrEmail(String userId, String email);

	// �������� ���� id ����� �̿��Ͽ� �ش�id�� ����� ��� ��ȸ
	public abstract List<User> getUsersByIds(List<String> ids);

	public abstract User getUserWithContactListById(String userId);

}