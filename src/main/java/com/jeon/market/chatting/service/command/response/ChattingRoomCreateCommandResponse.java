package com.jeon.market.chatting.service.command.response;

import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record ChattingRoomCreateCommandResponse(
        Long chatRoomId
) {
    public static ChattingRoomCreateCommandResponse of(Long chatRoomId) {
        return ChattingRoomCreateCommandResponse.builder()
                .chatRoomId(chatRoomId)
                .build();
    }
}
