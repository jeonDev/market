package com.jeon.market.application.member.endpoint;

import com.jeon.market.application.member.usecase.CreateMemberResponse;

public record MemberCreateResponse(
        Long id
) {
    public static MemberCreateResponse of(CreateMemberResponse response) {
        return new MemberCreateResponse(response.id());
    }
}
