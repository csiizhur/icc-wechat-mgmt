package com.iccspace.icc_wechat_mgmt.jpa;

public interface TUserService {

	public TUser save(TUser user);

	public void remove(long id);

	public TUser findOne(TUser user);
}
