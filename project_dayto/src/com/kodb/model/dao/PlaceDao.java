package com.kodb.model.dao;

import java.util.List;
import java.util.Map;

import com.kodb.model.vo.Place;
import com.kodb.model.vo.User;

public interface PlaceDao {

	public abstract Place selectPlace(String place_name);
	
	public abstract List<Place> selectPlacesByAddr(String addr);
	
	public abstract void updateRecomm(int placeId);
}