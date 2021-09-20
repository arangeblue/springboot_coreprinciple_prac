package com.coreprinciple.basic.discount;

import com.coreprinciple.basic.member.Member;

public interface DiscountPolicy {
    
    int discount(Member member, int price);

}
