package com.jeon.market.chatting.application.usecase.request;

import com.jeon.market.chatting.domain.type.ChatType;

public record ChattingRoomCommand(
        Long memberId,
        Long targetMemberId,
        Long chatRoomId,
        ChatType chatType
) {
}
