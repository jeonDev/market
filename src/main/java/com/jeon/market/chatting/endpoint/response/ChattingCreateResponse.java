package com.jeon.market.chatting.endpoint.response;

import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record ChattingCreateResponse(
        Long chatRoomId
) {

    public static ChattingCreateResponse of(Long chatRoomId) {
        return ChattingCreateResponse.builder()
                .chatRoomId(chatRoomId)
                .build();
    }
}
