package com.coreprinciple.basic.order;
import com.coreprinciple.basic.AppConfig;
import com.coreprinciple.basic.member.MemberService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;    
    
public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void setup(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }
        
}
    