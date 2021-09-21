package com.coreprinciple.basic.member;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 *@title : MemberRepositoryTest
 *@author : wikyubok 
 *@date : "2021-09-19 14:49:58"
*/
    
public class MemberRepositoryTest {
    
    private MemberService memberService;

    @Test
    public void 저장_및_조회() {
        // given
        Member memberA = new Member(1L, "memberA", Grade.VIP);

        // when    
        memberService.join(memberA);

        Member findMember = memberService.findMember(1L);

        // then
        assertThat(findMember.getName()).isEqualTo(memberA.getName());
    }
    

}
    