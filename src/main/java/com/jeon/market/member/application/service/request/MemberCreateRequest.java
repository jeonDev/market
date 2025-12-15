package com.jeon.market.member.application.service.request;

import com.jeon.market.member.domain.Member;

public record MemberCreateRequest(
        String loginId,
        String password,
        String name,
        String phoneNumber
) {
    public Member toEntity() {
        return Member.createMember(loginId, password, name, phoneNumber);
    }
}
