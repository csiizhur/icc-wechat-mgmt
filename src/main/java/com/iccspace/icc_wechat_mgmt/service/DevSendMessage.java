package com.iccspace.icc_wechat_mgmt.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
//Dev 环境实现类
@Component
@Profile("dev")
public class DevSendMessage implements SendMessage {

    @Override
    public void send() {
        System.out.println(">>>>>>>>Dev Send()<<<<<<<<");
    }

}
