package com.jeon.market.application.member.usecase;

import com.jeon.market.application.member.domain.Member;
import com.jeon.market.application.member.domain.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateMemberService {

    private final MemberRepository memberRepository;

    public CreateMemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public CreateMemberResponse createMember(String loginId, String password, String name, String phoneNumber) {
        Member member = Member.createMember(loginId, password, name, phoneNumber);
        return CreateMemberResponse.of(memberRepository.createMember(member));
    }

}
