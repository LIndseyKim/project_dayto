package com.kodb.model.vo;

public class Place {

	private int placeId;
	private String placeName;
	private String placeTel;
	private String placeCategory;	
	private String placeAddr;
	private String placeAddr2;
	private double addressX;
	private double addressY;
	private String placeRecomm;
	private String placePic;
	
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
	
	
	public String getPlaceAddr2() {
		return placeAddr2;
	}

	public void setPlaceAddr2(String placeAddr2) {
		this.placeAddr2 = placeAddr2;
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

	public String getPlaceRecomm() {
		return placeRecomm;
	}

	public void setPlaceRecomm(String placeRecomm) {
		this.placeRecomm = placeRecomm;
	}

	public String getPlacePic() {
		return placePic;
	}

	public void setPlacePic(String placePic) {
		this.placePic = placePic;
	}

	@Override
	public String toString() {
		return "Place [placeId=" + placeId + ", placeName=" + placeName
				+ ", placeTel=" + placeTel + ", placeCategory=" + placeCategory
				+ ", placeAddr=" + placeAddr + ", placeAddr2=" + placeAddr2
				+ ", addressX=" + addressX + ", addressY=" + addressY
				+ ", placeRecomm=" + placeRecomm + ", placePic=" + placePic
				+ "]";
	}

	
}
