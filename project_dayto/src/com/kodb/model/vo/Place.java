package com.kodb.model.vo;

import java.util.Date;

public class Place {

	private int placeId;
	private String placeName;
	private String placeTel;
	private String placeCategory;	
	private String placeAddr;
	
	public Place() {
		super();
	}

	public int getPlaceId() {
		return placeId;
	}

	public String getPlaceName() {
		return placeName;
	}
	
	public String getPlaceTel() {
		return placeTel;
	}


	public String getPlaceCategory() {
		return placeCategory;
	}


	public String getPlaceAddr() {
		return placeAddr;
	}

	@Override
	public String toString() {
		return "place [placeId=" + placeId + ", placeName=" + placeName 
				+ ", placeTel=" + placeTel + ", placeCategory=" + placeCategory 
				+ ", placeAddr=" + placeAddr+ "]";
	}
}
