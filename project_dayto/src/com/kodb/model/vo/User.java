package com.kodb.model.vo;

import javax.xml.bind.annotation.XmlRootElement;

// value Object
@XmlRootElement
public class User {
	
	private String user_email;
	private String user_pwd;
	private String user_name;
	private char user_type;
	private String user_profile;
	private String user_pic;
	
	public User(String user_email, String user_pwd, String user_name,
			char user_type, String user_profile, String user_pic) {
		super();
		this.user_email = user_email;
		this.user_pwd = user_pwd;
		this.user_name = user_name;
		this.user_type = user_type;
		this.user_profile = user_profile;
		this.user_pic = user_pic;
	}
	
	public User() {
		super();
	}

	public String getUser_email() {
		return user_email;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public String getUser_name() {
		return user_name;
	}

	public char getUser_type() {
		return user_type;
	}

	public String getUser_profile() {
		return user_profile;
	}

	public String getUser_pic() {
		return user_pic;
	}
	
	@Override
	public String toString() {
		return "User [user_email=" + user_email + ", user_pwd=" + user_pwd + 
				", user_type=" + user_type + ", user_profile=" + user_profile +
				", user_pic=" + user_pic + "]";
	}
}
