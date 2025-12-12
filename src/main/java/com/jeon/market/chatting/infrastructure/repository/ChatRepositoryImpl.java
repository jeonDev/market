package com.jeon.market.chatting.infrastructure.repository;

import com.jeon.market.chatting.application.domain.Chat;
import com.jeon.market.chatting.application.domain.ChatRepository;
import com.jeon.market.chatting.infrastructure.repository.mongo.MongoChatRepository;
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
