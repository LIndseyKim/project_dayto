package com.kodb.model.service;

import java.util.List;

import com.kodb.model.vo.User;

public interface UserService {

	public abstract void registerUser(User user);

	public abstract User getUser(String userId);

	// ���̵� ��ġ�ϴ� ȸ�� ����
	public abstract void removeUser(String user_email);

	// ���̵� �ش��ϴ� ȸ������ ����
	public abstract void modifyUser(User user);

	// ȸ�� ��ü ����Ʈ ��ȸ�Ͽ� ����
	public abstract List<User> getAllUser();

	// �α��� ������ true, �α��� ���н� false ����
	public abstract boolean login(String user_email, String user_pwd);

	public abstract List<User> getUsersByName(String user_name);

	public abstract List<User> getUsersByEmail(String user_email);

	// �������� ���� id ����� �̿��Ͽ� �ش�id�� ����� ��� ��ȸ
	public abstract List<User> getUsersByEmails(List<String> emails);

	public abstract User getUserWithContactListByEmail(String user_email);

}