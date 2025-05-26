package com.jeon.market.application.member.service.request;

import com.jeon.market.application.member.domain.Member;
import lombok.Builder;

@Builder
public record CreateMemberCommandRequest(
        String loginId,
        String password,
        String name,
        String phoneNumber
) {
    public Member toEntity() {
        return Member.createMember(loginId, password, name, phoneNumber);
    }
}
