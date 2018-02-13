package com.iot.spring.vo;

import javax.validation.constraints.NotNull;

public class UserInfoVO {
	private int uiNo;
	private String uiName;
	@NotNull
	private String uiId;
	private String uiPwd;
	private String uiEmail;
	private String admin;
	public int getUiNo() {
		return uiNo;
	}
	public void setUiNo(int uiNo) {
		this.uiNo = uiNo;
	}
	public String getUiName() {
		return uiName;
	}
	public void setUiName(String uiName) {
		this.uiName = uiName;
	}
	public String getUiId() {
		return uiId;
	}
	public void setUiId(String uiId) {
		this.uiId = uiId;
	}
	public String getUiPwd() {
		return uiPwd;
	}
	public void setUiPwd(String uiPwd) {
		this.uiPwd = uiPwd;
	}
	public String getUiEmail() {
		return uiEmail;
	}
	public void setUiEmail(String uiEmail) {
		this.uiEmail = uiEmail;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	@Override
	public String toString() {
		return "UserInfoVO [uiNo=" + uiNo + ", uiName=" + uiName + ", uiId=" + uiId + ", uiPwd=" + uiPwd + ", uiEmail="
				+ uiEmail + ", admin=" + admin + "]";
	}
	
	
}
