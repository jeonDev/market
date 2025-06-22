package com.jeon.market.application.chatting.domain.mongo;

import com.jeon.market.application.chatting.domain.type.MessageType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document("chat")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Chat {

    private Long chatId;
    private Long chatRoomId;
    private Long memberId;
    private MessageType messageType;
    private Object message;
}
