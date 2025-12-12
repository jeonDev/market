package com.jeon.market.member.application.usecase.request;

import com.jeon.market.member.application.service.request.MemberCreateRequest;
import lombok.Builder;

@Builder
public record CreateMemberCommand(
        String loginId,
        String password,
        String name,
        String phoneNumber
) {
    public MemberCreateRequest toRequest() {
        return new MemberCreateRequest(loginId, password, name, phoneNumber);
    }
}
