package com.coreprinciple.basic.xml;

import static org.assertj.core.api.Assertions.assertThat;

import com.coreprinciple.basic.member.MemberService;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class XmlAppConfig {
    

    @Test
    public void xmlAppContext() {
        
        GenericXmlApplicationContext xac = new GenericXmlApplicationContext("appConfig.xml");
    
        MemberService memberService = xac.getBean("memberService", MemberService.class);

        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
