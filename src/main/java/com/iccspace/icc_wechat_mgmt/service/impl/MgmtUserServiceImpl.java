package com.iccspace.icc_wechat_mgmt.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iccspace.icc_wechat_mgmt.core.Constants;
import com.iccspace.icc_wechat_mgmt.mapper.MgmtUserMapper;
import com.iccspace.icc_wechat_mgmt.model.MgmtAddUserResponse;
import com.iccspace.icc_wechat_mgmt.model.MgmtUserRequest;
import com.iccspace.icc_wechat_mgmt.service.MgmtUserService;

@Service
public class MgmtUserServiceImpl implements MgmtUserService{

	private Logger log=LoggerFactory.getLogger(getClass());
	@Autowired
    private MgmtUserMapper userMapper;

	@Override
	public Map<String, Object> queryMgmtUser(Map<String, String> queryMap) {
		Map<String,Object> result = userMapper.queryMgmtUser(queryMap);
		return result;
	}

	@Override
	public MgmtAddUserResponse addMgmtUser(MgmtUserRequest addMap) {
		MgmtAddUserResponse re=new MgmtAddUserResponse();
		int result = userMapper.insertMgmtUsers(addMap);
		if(result>0){
			re.setCode(Constants.SUCCESS_CODE);
			re.setMessage(Constants.ADD_DATA_SUCCESS_MESSAGE);
		}else{
			re.setCode(Constants.ADD_DATA_ERROR_CODE);
			re.setMessage(Constants.ADD_DATA_ERROR_MESSAGE);
		}
		return re;
	}
}
