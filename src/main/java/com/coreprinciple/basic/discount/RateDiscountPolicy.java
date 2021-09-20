package com.coreprinciple.basic.discount;

import com.coreprinciple.basic.member.Grade;
import com.coreprinciple.basic.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {


    private int discountRate = 10; // 10%

    @Override
    public int discount(Member member, int price) {
        
        if (member.getGrade() == Grade.VIP) {
            return price * discountRate / 100;
        } else {
            return 0;
        }
        
    }
    
}
