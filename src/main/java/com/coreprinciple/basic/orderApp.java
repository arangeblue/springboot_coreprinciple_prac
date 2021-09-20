package com.coreprinciple.basic;

import com.coreprinciple.basic.member.Grade;
import com.coreprinciple.basic.member.Member;
import com.coreprinciple.basic.member.MemberService;
import com.coreprinciple.basic.order.Order;
import com.coreprinciple.basic.order.OrderService;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class orderApp {
    
    public static void main(String[] args) {
        
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);
    

        Member member = new Member(2L, "member2", Grade.VIP);

        memberService.join(member);

        Order createdOrder = orderService.createdOrder(member.getId(), "itemB", 20000);


        System.out.println("order  :  " + createdOrder);

    }
}
