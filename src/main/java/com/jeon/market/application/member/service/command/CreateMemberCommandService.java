package com.jeon.market.application.member.service.command;

import com.jeon.market.application.member.domain.Member;
import com.jeon.market.application.member.domain.MemberRepository;
import com.jeon.market.application.member.service.command.request.CreateMemberCommandRequest;
import com.jeon.market.application.member.service.command.response.CreateMemberCommandResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateMemberCommandService {

    private final MemberRepository memberRepository;

    public CreateMemberCommandService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public CreateMemberCommandResponse createMember(CreateMemberCommandRequest request) {
        Member member = request.toEntity();
        memberRepository.createMember(member);
        return CreateMemberCommandResponse.of(member);
    }

}
