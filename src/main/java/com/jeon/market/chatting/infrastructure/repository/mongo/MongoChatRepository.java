package com.jeon.market.chatting.infrastructure.repository.mongo;

import com.jeon.market.chatting.application.domain.Chat;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoChatRepository extends MongoRepository<Chat, Long> {
}
