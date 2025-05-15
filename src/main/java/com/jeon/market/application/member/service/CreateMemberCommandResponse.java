package com.jeon.market.application.member.service;

import com.jeon.market.application.member.domain.Member;

public record CreateMemberCommandResponse(
        Long id,
        String loginId,
        String name,
        String phoneNumber
) {



    public static CreateMemberCommandResponse of(Member member) {
        return new CreateMemberCommandResponse(member.getId(),
                member.getLoginId(),
                member.getName(),
                member.getPhoneNumber()
        );
    }
}
