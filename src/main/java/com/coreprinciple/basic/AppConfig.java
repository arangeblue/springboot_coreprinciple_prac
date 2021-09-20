package com.coreprinciple.basic;

import com.coreprinciple.basic.discount.DiscountPolicy;
import com.coreprinciple.basic.discount.FixDiscountPolicy;
import com.coreprinciple.basic.member.MemberRepository;
import com.coreprinciple.basic.member.MemberService;
import com.coreprinciple.basic.member.MemberServiceImpl;
import com.coreprinciple.basic.member.MemoryMemberRepository;
import com.coreprinciple.basic.order.OrderService;
import com.coreprinciple.basic.order.OrderServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {
    

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

}
