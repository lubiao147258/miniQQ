package com.lbcto.vo;

public class UserInfoVO {
	private int id;
	private String name;
	private String level;
	private String email;
	private Integer onlineDay;

	public UserInfoVO(int id, String name, String level, String email, Integer onlineDay) {
		super();
		this.id = id;
		this.name = name;
		this.level = level;
		this.email = email;
		this.onlineDay = onlineDay;
	}

	public UserInfoVO() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getOnlineDay() {
		return onlineDay;
	}

	public void setOnlineDay(Integer onlineDay) {
		this.onlineDay = onlineDay;
	}

	@Override
	public String toString() {
		return "UserInfoVO [id=" + id + ", name=" + name + ", level=" + level + ", email=" + email + ", onlineDay="
				+ onlineDay + "]";
	}

}
