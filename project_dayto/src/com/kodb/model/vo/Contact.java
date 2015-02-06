package com.kodb.model.vo;

public class Contact {

	private int no;
	private String name;
	private String phone;
	private String birthDate;
	private String userId;
	
	public Contact() {
		super();
	}
	public Contact(int no, String name, String phone, String birthDate) {
		super();
		this.no = no;
		this.name = name;
		this.phone = phone;
		this.birthDate = birthDate;
	}
	public Contact(int no, String name, String phone, String birthDate,
			String userId) {
		this(no, name, phone, birthDate);
		this.userId = userId;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Contact [no=" + no + ", name=" + name + ", phone=" + phone
				+ ", birthDate=" + birthDate + ", userId=" + userId + "]";
	}
	
	
	
}
