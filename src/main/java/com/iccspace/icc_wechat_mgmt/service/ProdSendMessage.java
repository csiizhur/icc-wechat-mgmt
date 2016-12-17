package com.iccspace.icc_wechat_mgmt.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
//prod环境实现类
@Component
@Profile("prod")
public class ProdSendMessage implements SendMessage {

    @Override
    public void send() {
        System.out.println(">>>>>>>>Prod Send()<<<<<<<<");
    }

}
