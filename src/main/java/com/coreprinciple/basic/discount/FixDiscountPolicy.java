package com.coreprinciple.basic.discount;

import com.coreprinciple.basic.member.Grade;
import com.coreprinciple.basic.member.Member;

import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        

        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;   
        }
        

    }



}
