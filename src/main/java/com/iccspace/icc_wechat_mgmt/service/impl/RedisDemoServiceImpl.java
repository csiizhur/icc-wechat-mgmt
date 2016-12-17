package com.iccspace.icc_wechat_mgmt.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.iccspace.icc_wechat_mgmt.mapper.MgmtUserMapper;
import com.iccspace.icc_wechat_mgmt.service.RedisDemoService;

@Service  
public class RedisDemoServiceImpl implements RedisDemoService{
	@Autowired
	private MgmtUserMapper userMapper;
	
    @Cacheable(value = "usercache",keyGenerator = "wiselyKeyGenerator")  
    public Map<String,Object> findUser(String userName){
    	return userMapper.queryMgmtUserByUserName(userName);
    } 
}