package com.jeon.market.chatting.infrastructure.mongo;

import com.jeon.market.chatting.domain.mongo.Chat;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoChatRepository extends MongoRepository<Chat, Long> {
}
