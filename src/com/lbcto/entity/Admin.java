package com.lbcto.entity;

public class Admin {

	private int loginId;
	private String loginPsw;

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getLoginPsw() {
		return loginPsw;
	}

	public void setLoginPsw(String loginPsw) {
		this.loginPsw = loginPsw;
	}

	public Admin(int loginId, String loginPsw) {
		super();
		this.loginId = loginId;
		this.loginPsw = loginPsw;
	}

	public Admin() {
		super();
	}

	@Override
	public String toString() {
		return "Admin [loginId=" + loginId + ", loginPsw=" + loginPsw + "]";
	}

}
