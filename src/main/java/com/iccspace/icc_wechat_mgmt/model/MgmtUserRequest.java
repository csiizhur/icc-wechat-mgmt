package com.iccspace.icc_wechat_mgmt.model;

import java.io.Serializable;

public class MgmtUserRequest implements Serializable {
	private static final long serialVersionUID = 5298859149829994422L;

	private String userName;
	private String password;
	
	private String userId;
	private String headImage;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getHeadImage() {
		return headImage;
	}
	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}
	
	
}
