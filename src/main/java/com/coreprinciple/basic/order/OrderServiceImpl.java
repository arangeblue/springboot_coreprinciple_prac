package com.coreprinciple.basic.order;

import com.coreprinciple.basic.discount.DiscountPolicy;
import com.coreprinciple.basic.discount.FixDiscountPolicy;
import com.coreprinciple.basic.member.Member;
import com.coreprinciple.basic.member.MemberRepository;
import com.coreprinciple.basic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;    
    private final DiscountPolicy discountPolicy;
    
        public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
            this.memberRepository = memberRepository;
            this.discountPolicy = discountPolicy;
        }
    
    

    @Override
    public Order createdOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);

        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);

    }
    
    //테스트 용도
    public MemberRepository getMemberRepository() {
       
        return memberRepository;
    }
    
}
