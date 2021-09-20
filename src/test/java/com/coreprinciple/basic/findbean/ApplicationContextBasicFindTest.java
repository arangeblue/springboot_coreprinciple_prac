package com.coreprinciple.basic.findbean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.coreprinciple.basic.AppConfig;
import com.coreprinciple.basic.member.MemberService;
import com.coreprinciple.basic.member.MemberServiceImpl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    public void findByBeanName() {
        // given
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        // then
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }

    @Test
    @DisplayName("빈 타입으로 조회")
    public void findBeanByType() {
        // given
        MemberService memberService = ac.getBean(MemberService.class);

        // then
        assertThat(memberService).isInstanceOf(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }


    @Test
    @DisplayName("구체적인 타입으로 조회")
    public void findBeanBySpecificType() {

        MemberService memberService = ac.getBean("memberService", MemberService.class);

        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }

    @Test
    @DisplayName("빈 이름으로 조회 x")
    public void findBeanByNameX() {
        
        assertThrows(NoSuchBeanDefinitionException.class,() -> {
            ac.getBean("XXXXX", MemberService.class);
        });

    }

}

