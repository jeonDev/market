package com.jeon.market.member.application.usecase.response;

import com.jeon.market.member.domain.Member;

public record CreateMemberResult(
        Long id,
        String loginId,
        String name,
        String phoneNumber
) {



    public static CreateMemberResult of(Member member) {
        return new CreateMemberResult(member.getId(),
                member.getLoginId(),
                member.getName(),
                member.getPhoneNumber()
        );
    }
}
