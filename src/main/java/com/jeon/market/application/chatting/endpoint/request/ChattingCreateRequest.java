package com.jeon.market.application.chatting.endpoint.request;

import com.jeon.market.application.chatting.domain.type.ChatType;
import com.jeon.market.application.chatting.service.request.ChattingRoomCreateCommandRequest;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ChattingCreateRequest {
    @NotNull(message = "채팅 대상을 선택하세요.")
    private Long memberId;

    private Long chatRoomId;

    public ChattingRoomCreateCommandRequest toRequest(Long memberId) {
        if (memberId == null || memberId <= 0
                || this.memberId == null || this.memberId <= 0) {
            throw new IllegalArgumentException();
        }
        return ChattingRoomCreateCommandRequest.of(ChatType.PERSONAL, memberId, this.memberId, this.chatRoomId);
    }
}
