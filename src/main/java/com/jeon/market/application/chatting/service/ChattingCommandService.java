package com.jeon.market.application.chatting.service;

import com.jeon.market.application.chatting.domain.mongo.ChatRepository;
import com.jeon.market.application.chatting.domain.type.MessageType;
import org.springframework.stereotype.Service;

@Service
public class ChattingCommandService {

    private final ChatRepository chatRepository;

    public ChattingCommandService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    public void send(Long memberId,
                     Long roomId,
                     MessageType messageType,
                     Object message
                     ) {
        // 1. Room 조회

        // 2. Member 조회

        // 3. 저장

        // 4. Event 발생 (채팅 참여자에게 전송)
    }
}
