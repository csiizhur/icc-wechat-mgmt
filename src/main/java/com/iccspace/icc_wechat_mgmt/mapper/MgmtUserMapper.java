package com.iccspace.icc_wechat_mgmt.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.iccspace.icc_wechat_mgmt.model.MgmtUserRequest;

public interface MgmtUserMapper {
	@Select("select * from `wechat-mgmt-db`.mgmt_user where username = #{userName} and password=#{password}")
	@Results({
		@Result(id = true, column = "id", property = "userId"),
		@Result(column = "username", property = "userName"),
		@Result(column = "headimage", property = "headImage")
	})
    public Map<String,Object> queryMgmtUser(Map<String,String> user);
	@Select("select * from `wechat-mgmt-db`.mgmt_user where username = #{userName}")
	@Results({
		@Result(id = true, column = "id", property = "userId"),
		@Result(column = "username", property = "userName"),
		@Result(column = "headimage", property = "headImage"),
		@Result(column ="password",property="password")
	})
	public Map<String,Object> queryMgmtUserByUserName(String userName);
	
	@Insert("insert into `wechat-mgmt-db`.mgmt_user (id,username,password,headimage,create_time,create_userid,status) "
			+ "values(#{userId},#{userName},#{password},#{headImage},now(),'system',0)")  
    @SelectKey(statement="select replace(uuid(),'-','') from dual", keyProperty="userId", before=true, resultType=String.class)  
    public int insertMgmtUsers(MgmtUserRequest user);
}
