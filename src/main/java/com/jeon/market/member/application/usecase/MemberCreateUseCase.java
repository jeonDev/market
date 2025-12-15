package com.jeon.market.member.application.usecase;

import com.jeon.market.member.application.service.MemberService;
import com.jeon.market.member.application.usecase.request.CreateMemberCommand;
import com.jeon.market.member.application.usecase.response.CreateMemberResult;
import com.jeon.market.member.domain.Member;
import org.springframework.stereotype.Service;

@Service
public class MemberCreateUseCase {

    private final MemberService memberService;

    public MemberCreateUseCase(MemberService memberService) {
        this.memberService = memberService;
    }

    public CreateMemberResult execute(CreateMemberCommand command) {
        Member member = memberService.create(command.toRequest());

        return new CreateMemberResult(
                member.getId(),
                member.getLoginId(),
                member.getName(),
                member.getPhoneNumber()
        );
    }
}
