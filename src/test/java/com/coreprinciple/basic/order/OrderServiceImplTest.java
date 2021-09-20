package com.coreprinciple.basic.order;
import static org.assertj.core.api.Assertions.assertThat;

import com.coreprinciple.basic.member.Grade;
import com.coreprinciple.basic.member.Member;
import com.coreprinciple.basic.member.MemberService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;    
    
public class OrderServiceImplTest {

    private MemberService memberService = new MemberServiceImpl();
    private OrderService orderService = new OrderServiceImpl();


    @BeforeEach
    public void clear() {
        
    }

    @Test
    public void 주문_실행() {
        // given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        // when
        Order createdOrder = orderService.createdOrder(memberId, "itemA", 3000);

        // then
        System.out.println("order = " + createdOrder);

        assertThat(createdOrder.getItemPrice()).isEqualTo(3000);
        assertThat(createdOrder.getDiscountPrice()).isEqualTo(1000);

    }



}
    