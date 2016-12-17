package com.iccspace.icc_wechat_mgmt.model;

import java.io.Serializable;

public class MgmtQryUserResponse extends MgmtJsonResponse implements Serializable {

	private static final long serialVersionUID = -7566992366327950013L;

	private Object result;

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
	
	
}
