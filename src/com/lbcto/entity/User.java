package com.lbcto.entity;

public class User {

	private int userId;
	private String userName;
	private String userPsw;
	private int userLevelId;
	private String email;
	private int onlineDay;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPsw() {
		return userPsw;
	}

	public void setUserPsw(String userPsw) {
		this.userPsw = userPsw;
	}

	public int getUserLevelId() {
		return userLevelId;
	}

	public void setUserLevelId(int userLevelId) {
		this.userLevelId = userLevelId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPsw=" + userPsw + ", userLevelId="
				+ userLevelId + ", email=" + email + ", onlineDay=" + onlineDay + "]";
	}

	public int getOnlineDay() {
		return onlineDay;
	}

	public void setOnlineDay(int onlineDay) {
		this.onlineDay = onlineDay;
	}

	public User(int userId, String userName, String userPsw, int userLevelId, String email, int onlineDay) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPsw = userPsw;
		this.userLevelId = userLevelId;
		this.email = email;
		this.onlineDay = onlineDay;
	}
	
	public User(String userName, String userPsw, int userLevelId, String email, int onlineDay) {
		super();
		this.userName = userName;
		this.userPsw = userPsw;
		this.userLevelId = userLevelId;
		this.email = email;
		this.onlineDay = onlineDay;
	}

	public User() {
		super();
	}

}
