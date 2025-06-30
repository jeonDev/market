package com.jeon.market.application.chatting.domain.dto;

import org.springframework.web.socket.WebSocketMessage;

public record ChatMessage<T>(
        T data
) implements WebSocketMessage<T> {

    @Override
    public T getPayload() {
        return null;
    }

    @Override
    public int getPayloadLength() {
        return 0;
    }

    @Override
    public boolean isLast() {
        return false;
    }
}
