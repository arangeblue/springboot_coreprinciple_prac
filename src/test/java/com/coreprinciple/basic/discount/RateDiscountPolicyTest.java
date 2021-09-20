package com.coreprinciple.basic.discount;
import static org.assertj.core.api.Assertions.assertThat;

import com.coreprinciple.basic.member.Grade;
import com.coreprinciple.basic.member.Member;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;    
    
public class RateDiscountPolicyTest {

    private RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("vip는 10% 할인 적용")
    public void 정률할인_적용(){
        // given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberB", Grade.VIP);

        // when
        int discount = discountPolicy.discount(member, 10000);
    
        // then
        assertThat(discount).isEqualTo(1000);
    }


    @Test
    @DisplayName("vip이외의 등급에서는 할인 적용 x")
    public void vip_x() {

        Long memberId = 2L;
        Member member = new Member(memberId, "memberBasic", Grade.BASIC);
    
        int discount = discountPolicy.discount(member, 10000);

        assertThat(discount).isEqualTo(0);
    }
}
    