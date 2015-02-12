package com.kodb.model.vo;

import javax.xml.bind.annotation.XmlRootElement;

// value Object
@XmlRootElement
public class User {
	
	private String userEmail;
	private String userPwd;
	private String userName;
	private char userType;
	private String userProfile;
	private String userPic;
	
	
	public User(String userEmail, String userPwd, String userName,
			char userType, String userProfile, String userPic) {
		super();
		this.userEmail = userEmail;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userType = userType;
		this.userProfile = userProfile;
		this.userPic = userPic;
	}
	
	public User() {
		super();
	}
	
	public String getUserEmail() {
		return userEmail;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public char getUserType() {
		return userType;
	}

	public String getUserProfile() {
		return userProfile;
	}

	public String getUserPic() {
		return userPic;
	}

	@Override
	public String toString() {
		return "User [userEmail=" + userEmail + ", userPwd=" + userPwd
				+ ", userName=" + userName + ", userType=" + userType
				+ ", userProfile=" + userProfile + ", userPic=" + userPic + "]";
	}
}
