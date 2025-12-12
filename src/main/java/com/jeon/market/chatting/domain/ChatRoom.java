package com.jeon.market.chatting.domain;

import com.jeon.market.chatting.domain.type.ChatType;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "CHAT_ROOM")
@Access(AccessType.FIELD)
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CHAT_ROOM_ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "CHAT_TYPE")
    private ChatType chatType;


    public static ChatRoom create(ChatType chatType) {
        return ChatRoom.builder()
                .chatType(chatType)
                .build();
    }
}
