package com.jeon.market.chatting.service.query;

import com.jeon.market.chatting.domain.mongo.ChatRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class ChattingQueryService {

    private final ChatRepository chatRepository;

    public ChattingQueryService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }


    @Transactional(readOnly = true)
    public void list() {

    }
}
