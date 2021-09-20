package com.coreprinciple.basic.member;

public interface MemberService {
    

    void join(Member member);

    Member findMember(Long memberId);

}
