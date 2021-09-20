package com.coreprinciple.basic.member;
import com.coreprinciple.basic.AppConfig;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;    
    
public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void setup(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }
        
}
    