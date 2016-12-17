package com.iccspace.icc_wechat_mgmt.service;

import java.util.Map;

import com.iccspace.icc_wechat_mgmt.model.MgmtAddUserResponse;
import com.iccspace.icc_wechat_mgmt.model.MgmtUserRequest;

public interface MgmtUserService {

	public Map<String,Object> queryMgmtUser(Map<String,String> queryMap);
	
	public MgmtAddUserResponse addMgmtUser(MgmtUserRequest addMap);
}
