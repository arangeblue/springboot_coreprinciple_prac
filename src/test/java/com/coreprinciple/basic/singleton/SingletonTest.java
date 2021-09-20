package com.coreprinciple.basic.singleton;

import static org.assertj.core.api.Assertions.assertThat;

import com.coreprinciple.basic.AppConfig;
import com.coreprinciple.basic.member.MemberService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {
 
    
    @Test
    @DisplayName("스프링 없는 순수 DI컨테이너")
    public void pureContainer() {

        AppConfig appConfig = new AppConfig();

        // 1. 호출할 때마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        assertThat(memberService2).isNotSameAs(memberService1);
    }

    
    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    public void singletonServiceTest() {
    

        // 1. 조회 : 호출할 때마다 같은 객체가 반환
        SingletonService instance1 = SingletonService.getInstance();
        SingletonService instance2 = SingletonService.getInstance();
    
        System.out.println("instance1 = " + instance1);
        System.out.println("instance2 = " + instance2);

        assertThat(instance2).isEqualTo(instance1);
        instance1.logic();
    
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤 패턴")
    public void springContainer() {
    
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    
    
        // 1.조회 : 객체를 호출할 때마다 같은 객체가 반환
        MemberService memberService1 = ac.getBean("memberService",MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);
        
        System.out.println("memberService 1 = " + memberService1);
        System.out.println("memberService 2 = " + memberService2);
    
        assertThat(memberService1).isEqualTo(memberService2);

    }


}
