package com.coreprinciple.basic.singleton;

import static org.assertj.core.api.Assertions.assertThat;

import com.coreprinciple.basic.AppConfig;
import com.coreprinciple.basic.member.MemberServiceImpl;
import com.coreprinciple.basic.member.MemoryMemberRepository;
import com.coreprinciple.basic.order.OrderServiceImpl;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {
    

    @Test
    public void configurationTest() {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemoryMemberRepository memberRepository = ac.getBean("memberRepository", MemoryMemberRepository.class);

        //모두 같은 인스턴스를 참조하는지 확인
        System.out.println("memberService -> memberRepository = " + memberService.getMemberRepository());
        System.out.println("orderService -> memberRepository = " + orderService.getMemberRepository());
        System.out.println("memberRepository = " + memberRepository);

        assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
    }
    

    @Test
    public void configurationDeep() {
    
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        AppConfig appConfig = ac.getBean(AppConfig.class);

        System.out.println("bean = " + appConfig);

    }

}
