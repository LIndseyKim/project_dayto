package com.kodb.model.service;

import java.util.List;

import com.kodb.model.vo.User;

public interface UserService {

	public abstract void registerUser(User user);

	public abstract User getUser(String userEmail);

	// ���̵� ��ġ�ϴ� ȸ�� ����
	public abstract void removeUser(String userEmail);

	// ���̵� �ش��ϴ� ȸ������ ����
	public abstract void modifyUser(User user);
	
	// ȸ�� ��ü ����Ʈ ��ȸ�Ͽ� ����
	public abstract List<User> getAllUser();

	// �α��� ������ true, �α��� ���н� false ����
	public abstract boolean login(String userEmail, String userPwd);

	public abstract List<User> getUsersByName(String userName);

	public abstract List<User> getUsersByEmail(String userEmail);

	// �������� ���� id ����� �̿��Ͽ� �ش�id�� ����� ��� ��ȸ
	public abstract List<User> getUsersByEmails(List<String> emails);

	public abstract User getUserWithContactListByEmail(String userEmail);

}