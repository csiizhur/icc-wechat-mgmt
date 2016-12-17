package com.iccspace.icc_wechat_mgmt.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.iccspace.icc_wechat_mgmt.jpa.TUser;
public interface DemoInfoRepository extends CrudRepository<TUser, Long> {

}
