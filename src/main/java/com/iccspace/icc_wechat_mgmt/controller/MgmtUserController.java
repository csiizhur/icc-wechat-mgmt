package com.iccspace.icc_wechat_mgmt.controller;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.plexus.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iccspace.icc_wechat_mgmt.model.MgmtQryUserResponse;
import com.iccspace.icc_wechat_mgmt.model.MgmtUserRequest;
import com.iccspace.icc_wechat_mgmt.core.Constants;
import com.iccspace.icc_wechat_mgmt.model.MgmtAddUserResponse;
import com.iccspace.icc_wechat_mgmt.model.MgmtJsonResponse;
import com.iccspace.icc_wechat_mgmt.service.MgmtUserService;

@RestController
@RequestMapping("mgmt/user")
public class MgmtUserController {

	@Autowired
	private MgmtUserService userService;
	
	@RequestMapping(method=RequestMethod.POST,value="/login")
	public @ResponseBody MgmtQryUserResponse login(@RequestBody MgmtUserRequest user){
		MgmtQryUserResponse mgmt=new MgmtQryUserResponse();
		Map<String,String> params=new HashMap<String,String>();
		if(StringUtils.isEmpty(user.getUserName())){
			mgmt.setCode(Constants.USER_LOGIN_ERROR_CODE);
			mgmt.setMessage(Constants.USER_LOGIN_USERNAME_MESSAGE);
			return mgmt;
		}else if(StringUtils.isEmpty(user.getPassword())){
			mgmt.setCode(Constants.USER_LOGIN_ERROR_CODE);
			mgmt.setMessage(Constants.USER_LOGIN_PASSWORD_MESSAGE);
			return mgmt;
			
		}else{		
			params.put("userName", user.getUserName());
			params.put("password",user.getPassword());
			Map<String,Object> result=userService.queryMgmtUser(params);
			if(result.isEmpty()){
				mgmt.setCode(Constants.USER_LOGIN_ERROR_CODE);
				mgmt.setMessage(Constants.USER_LOGIN_ERROR_MESSAGE);
			}else{
				mgmt.setResult(result);
				mgmt.setCode(Constants.SUCCESS_CODE);
				mgmt.setMessage(Constants.USER_LOGIN_SUCCESS_MESSAGE);
			}
			return mgmt;
		}
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/loginOut")
	public @ResponseBody MgmtJsonResponse userLoginOut(){
		MgmtJsonResponse result=new MgmtJsonResponse();
		return result;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/addMgmtUser")
	public @ResponseBody MgmtAddUserResponse addMgmtUserInfo(@RequestBody MgmtUserRequest user){
		MgmtAddUserResponse resultMap= userService.addMgmtUser(user);
		return resultMap;
	}
}
