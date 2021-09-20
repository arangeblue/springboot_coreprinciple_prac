package com.coreprinciple.basic;

import com.coreprinciple.basic.member.Grade;
import com.coreprinciple.basic.member.Member;
import com.coreprinciple.basic.member.MemberService;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class MemberApp {
    
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberVIP", Grade.VIP);

        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("find Member : " + findMember);
        System.out.println("new Member :  " + member.getName());

    }
}
