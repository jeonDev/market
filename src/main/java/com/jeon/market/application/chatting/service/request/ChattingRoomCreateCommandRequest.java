package com.jeon.market.application.chatting.service.request;

import com.jeon.market.application.chatting.domain.type.ChatType;
import lombok.Builder;

@Builder
public record ChattingRoomCreateCommandRequest(
        Long memberId,
        Long targetMemberId,
        ChatType chatType
) {
}
