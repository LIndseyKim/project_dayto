package com.kodb.model.service;

import java.util.HashMap;
import java.util.List;

import com.kodb.model.dao.PlaceDao;
import com.kodb.model.vo.Place;
import com.kodb.model.vo.User;

public class PlaceServiceImpl implements PlaceService {
	
	/*private UserDao userDao = new UserDao(); //�̰Ŵ� ���� �ڵ���!! new�� �ϴٴ�!!
*/	private PlaceDao placeDao;
	
	
	public void setPlaceDao(PlaceDao placeDao) {
		this.placeDao = placeDao;
	}
	
	@Override
	public Place getPlace(String placeName){
		System.out.println("[getPlace_name]");
		// ���̵� ��ġ�ϴ� ȸ������ ��ȸ : select
		return placeDao.selectPlace(placeName);
	}
	
	@Override
	public List<Place> getPlacesByAddr(String addr){
		System.out.println("[getPlace_byAddr]");
		return placeDao.selectPlacesByAddr(addr);
	}

	@Override
	public void recommPlace(int placeId) {
		System.out.println("[recommPlace]");
		placeDao.updateRecomm(placeId);
		
		
		
	}
	
	
	
	
}