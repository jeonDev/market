package com.jeon.market.chatting.endpoint.payload;

import com.jeon.market.chatting.application.domain.type.ChatType;
import com.jeon.market.chatting.application.usecase.request.ChattingRoomCommand;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record ChattingCreatePayload() {

    public record Request(
            @Schema(description = "채팅 대상 선택(개인)", example = "1") @NotNull(message = "채팅 대상을 선택하세요.") Long memberId,
            @Schema(description = "채팅방 선택(방)", example = "1") Long chatRoomId,
            @Schema(description = "채팅방 유형", example = "PERSONAL") ChatType chatType
    ) {

        public ChattingRoomCommand toRequest(Long memberId) {
            return new ChattingRoomCommand(
                    memberId,
                    this.memberId,
                    this.chatRoomId,
                    this.chatType
            );
        }
    }

    public record Response(
            @Schema(description = "채팅방 선택(방)", example = "1") Long chatRoomId
    ) {

    }
}
