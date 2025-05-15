package com.jeon.market.application.member.endpoint;

import com.jeon.market.application.member.service.CreateMemberCommandResponse;

public record MemberCreateResponse(
        Long id
) {
    public static MemberCreateResponse of(CreateMemberCommandResponse response) {
        return new MemberCreateResponse(response.id());
    }
}
