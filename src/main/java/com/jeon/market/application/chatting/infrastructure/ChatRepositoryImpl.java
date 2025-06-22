package com.jeon.market.application.chatting.infrastructure;

import com.jeon.market.application.chatting.domain.mongo.Chat;
import com.jeon.market.application.chatting.domain.mongo.ChatRepository;
import com.jeon.market.application.chatting.infrastructure.mongo.MongoChatRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ChatRepositoryImpl implements ChatRepository {

    private final MongoChatRepository mongoChatRepository;

    public ChatRepositoryImpl(MongoChatRepository mongoChatRepository) {
        this.mongoChatRepository = mongoChatRepository;
    }

    @Override
    public Chat save(Chat chat) {
        return mongoChatRepository.save(chat);
    }
}
