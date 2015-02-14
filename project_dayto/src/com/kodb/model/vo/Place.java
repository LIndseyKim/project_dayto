package com.kodb.model.vo;

import java.util.Date;

public class Place {

	private int placeId;
	private String placeName;
	private String placeTel;
	private String placeCategory;	
	private String placeAddr;
	private double addressX;
	private double addressY;
	
	public Place() {
		super();
	}
	
	public int getPlaceId() {
		return placeId;
	}


	public void setPlaceId(int placeId) {
		this.placeId = placeId;
	}


	public String getPlaceName() {
		return placeName;
	}


	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}


	public String getPlaceTel() {
		return placeTel;
	}


	public void setPlaceTel(String placeTel) {
		this.placeTel = placeTel;
	}


	public String getPlaceCategory() {
		return placeCategory;
	}


	public void setPlaceCategory(String placeCategory) {
		this.placeCategory = placeCategory;
	}


	public String getPlaceAddr() {
		return placeAddr;
	}


	public void setPlaceAddr(String placeAddr) {
		this.placeAddr = placeAddr;
	}

	public double getAddressX() {
		return addressX;
	}

	public void setAddressX(double addressX) {
		this.addressX = addressX;
	}

	public double getAddressY() {
		return addressY;
	}

	public void setAddressY(double addressY) {
		this.addressY = addressY;
	}

	@Override
	public String toString() {
		return "Place [placeId=" + placeId + ", placeName=" + placeName
				+ ", placeTel=" + placeTel + ", placeCategory=" + placeCategory
				+ ", placeAddr=" + placeAddr + ", addressX=" + addressX
				+ ", addressY=" + addressY + "]";
	}
}
