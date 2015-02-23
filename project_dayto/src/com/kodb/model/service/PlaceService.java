package com.kodb.model.service;

import java.util.List;

import com.kodb.model.vo.Place;
import com.kodb.model.vo.User;

public interface PlaceService {

	public abstract Place getPlace(String placeName);
	public abstract List<Place> getPlacesByAddr(String addr);
	public abstract void recommPlace(int placeId);


	// ȸ�� ��ü ����Ʈ ��ȸ�Ͽ� ����
	//public abstract List<Place> getAllPlace();
	/*
	// �α��� ����� true, �α��� ���н� false ����
	public abstract boolean login(String user_email, String user_pwd);

	public abstract List<User> getUsersByName(String user_name);

	public abstract List<User> getUsersByEmail(String user_email);

	// �������� ���� id ����� �̿��Ͽ� �ش�id�� ����� ��� ��ȸ
	public abstract List<User> getUsersByEmails(List<String> emails);

	public abstract User getUserWithContactListByEmail(String user_email);
*/
}