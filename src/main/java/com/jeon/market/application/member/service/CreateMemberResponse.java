package com.jeon.market.application.member.service;

import com.jeon.market.application.member.domain.Member;

public record CreateMemberResponse(
        Long id,
        String loginId,
        String name,
        String phoneNumber
) {



    public static CreateMemberResponse of(Member member) {
        return new CreateMemberResponse(member.getId(),
                member.getLoginId(),
                member.getName(),
                member.getPhoneNumber()
        );
    }
}
