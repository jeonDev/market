package com.jeon.market.chatting.domain.mongo;

import com.jeon.market.chatting.domain.type.MessageType;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document("chat")
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Chat {

    private Long chatId;
    private Long chatRoomId;
    private Long memberId;
    private MessageType messageType;
    private Object message;
}
