package com.iccspace.icc_wechat_mgmt.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_user")
public class TUser implements Serializable {
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	//@Column(name="id",nullable=true)
	private long id;
	//@Column(name="username",nullable=false)
	private String username;
	//@Column(name="password",nullable=false)
	private String password;

	public TUser() {
		// TODO Auto-generated constructor stub
	}
	

	public TUser(long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}


	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	       public String toString() {
	              return"DemoInfo [id=" + id + ",name=" + username + ", pwd=" + password + "]";
	       }
}
