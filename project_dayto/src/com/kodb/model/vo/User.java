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

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public char getUserType() {
		return userType;
	}

	public void setUserType(char userType) {
		this.userType = userType;
	}

	public String getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(String userProfile) {
		this.userProfile = userProfile;
	}

	public String getUserPic() {
		return userPic;
	}

	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}

	@Override
	public String toString() {
		return "User [userEmail=" + userEmail + ", userPwd=" + userPwd
				+ ", userName=" + userName + ", userType=" + userType
				+ ", userProfile=" + userProfile + ", userPic=" + userPic + "]";
	}
}
