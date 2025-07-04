package com.jeon.market.application.member.endpoint.response;

import com.jeon.market.application.member.service.command.response.CreateMemberCommandResponse;

public record MemberCreateResponse(
        Long id
) {
    public static MemberCreateResponse of(CreateMemberCommandResponse response) {
        return new MemberCreateResponse(response.id());
    }
}
