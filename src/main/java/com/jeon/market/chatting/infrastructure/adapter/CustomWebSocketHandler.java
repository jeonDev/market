package com.jeon.market.chatting.infrastructure.adapter;

import com.jeon.market.chatting.application.domain.dto.ChatMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Configuration
public class CustomWebSocketHandler extends TextWebSocketHandler {

    private final ConcurrentHashMap<String, WebSocketSession> clientSession = new ConcurrentHashMap<>();

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        clientSession.get("")
                .sendMessage(new ChatMessage<>(""));
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        log.info("[WebSocket] afterConnectionEstablished Session Add : {}", session.getId());
        clientSession.put(session.getId(), session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        log.info("[WebSocket] afterConnectionClosed Session Close : {} {} {}", session.getId(), status.getCode(), status.getReason());
        clientSession.remove(session);
    }
}
