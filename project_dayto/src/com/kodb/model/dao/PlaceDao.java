package com.kodb.model.dao;

import java.util.List;
import java.util.Map;

import com.kodb.model.vo.Place;
import com.kodb.model.vo.User;

public interface PlaceDao {

	public abstract Place selectPlace(String place_name);
	public abstract List<Place> selectPlacesByAddr(String addr);
	//public abstract boolean selectPlace(String place_name);

	/*public abstract List<User> selectUser();

	public abstract List<User> selectUsersByName(String user_name);

	public abstract List<User> selectUsersByEmail(
			Map<String, Object> conditions);

	public abstract List<User> selectUsersByEmails(List<String> emails);

	public abstract User selectUserWithContactListByEmail(String user_email);*/

}