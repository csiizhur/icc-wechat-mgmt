package com.iccspace.icc_wechat_mgmt.service;

import java.util.Map;

public interface RedisDemoService {

	public Map<String,Object> findUser(String userName);
}
