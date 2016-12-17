package com.iccspace.icc_wechat_mgmt.model;

import javax.persistence.Table;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@Table(name="wechat-mgmt-db.mgmt_user")
public class Greeting extends ResourceSupport {  
    private String userId;  
    private String userName;  

    
	public String getUserId() {
		return userId;
	}


	public void setUserId(String id) {
		this.userId = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	@JsonCreator  
    @JsonIgnoreProperties(ignoreUnknown = true)  
    public Greeting(@JsonProperty(value = "gid") String gid, @JsonProperty(value = "content") String content) {  
        this.userId = gid;  
        this.userName = content;  
    }
}