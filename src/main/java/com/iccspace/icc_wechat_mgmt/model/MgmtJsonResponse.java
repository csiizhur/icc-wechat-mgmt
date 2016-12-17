package com.iccspace.icc_wechat_mgmt.model;

import java.io.Serializable;

/**
 * 
 * @description 管理端json返回模版
 * @author zhur
 * @date 2016年12月5日-下午3:16:01
 */
public class MgmtJsonResponse implements Serializable {
	private static final long serialVersionUID = -1871055480003147313L;

	private String code;
	
	private String message;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
