package com.jeon.market.application.chatting.infrastructure.mongo;

import com.jeon.market.application.chatting.domain.mongo.Chat;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoChatRepository extends MongoRepository<Chat, Long> {
}
