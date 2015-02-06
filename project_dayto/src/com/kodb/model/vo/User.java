package com.kodb.model.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

// value Object
@XmlRootElement
public class User {
	
	private String userId;
	private String password;
	private String name;
	private String email;
	
	private List<Contact> contactList;
	
	
	public User(String userId, String password, String name, String email) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.email = email;
	}
	
	public User() {
		super();
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", name="
				+ name + ", email=" + email + "]";
	}
	
	
}
