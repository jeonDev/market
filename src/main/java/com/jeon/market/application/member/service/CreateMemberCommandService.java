package com.jeon.market.application.member.service;

import com.jeon.market.application.member.domain.Member;
import com.jeon.market.application.member.domain.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateMemberCommandService {

    private final MemberRepository memberRepository;

    public CreateMemberCommandService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public CreateMemberCommandResponse createMember(String loginId, String password, String name, String phoneNumber) {
        Member member = Member.createMember(loginId, password, name, phoneNumber);
        return CreateMemberCommandResponse.of(memberRepository.createMember(member));
    }

}
