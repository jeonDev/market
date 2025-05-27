package com.jeon.market.application.chatting.infrastructure;

import com.jeon.market.application.chatting.domain.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaChatRoomRepository extends JpaRepository<ChatRoom, Long> {
}
