package com.jeon.market.chatting.service.command.request;

import com.jeon.market.chatting.domain.type.ChatType;
import lombok.AccessLevel;
import lombok.Builder;

import java.util.Objects;

@Builder(access = AccessLevel.PRIVATE)
public record ChattingRoomCreateCommandRequest(
        Long memberId,
        Long targetMemberId,
        Long chatRoomId,
        ChatType chatType
) {

    public static ChattingRoomCreateCommandRequest of(ChatType chatType, Long memberId, Long targetMemberId, Long chatRoomId) {
        if (Objects.equals(memberId, targetMemberId)) {
            throw new IllegalArgumentException();
        }
        return ChattingRoomCreateCommandRequest.builder()
                .chatType(chatType)
                .memberId(memberId)
                .targetMemberId(targetMemberId)
                .chatRoomId(chatRoomId)
                .build();
    }
}
