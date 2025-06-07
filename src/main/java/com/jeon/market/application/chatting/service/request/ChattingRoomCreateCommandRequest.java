package com.jeon.market.application.chatting.service.request;

import com.jeon.market.application.chatting.domain.type.ChatType;
import lombok.AccessLevel;
import lombok.Builder;

import java.util.Objects;

@Builder(access = AccessLevel.PRIVATE)
public record ChattingRoomCreateCommandRequest(
        Long memberId,
        Long targetMemberId,
        ChatType chatType
) {

    public static ChattingRoomCreateCommandRequest of(ChatType chatType, Long memberId, Long targetMemberId) {
        if (Objects.equals(memberId, targetMemberId)) {
            throw new IllegalArgumentException();
        }
        return ChattingRoomCreateCommandRequest.builder()
                .chatType(chatType)
                .memberId(memberId)
                .targetMemberId(targetMemberId)
                .build();
    }
}
