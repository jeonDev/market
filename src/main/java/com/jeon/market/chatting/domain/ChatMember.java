package com.jeon.market.chatting.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 1:1 채팅
 */

@Getter
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "CHAT_MEMBER")
@Access(AccessType.FIELD)
public class ChatMember {

    @EmbeddedId
    private ChatMemberId id;

    @Column(name = "PARTICIPATION_DATE")
    private LocalDateTime participationDate;

    @Column(name = "USE_YN")
    private boolean useYn;

    public static ChatMember create(ChatMemberId id) {
        return ChatMember.builder()
                .id(id)
                .participationDate(LocalDateTime.now())
                .useYn(true)
                .build();
    }

    public void delete() {
        this.useYn = false;
    }

    public ChatMember use() {
        this.useYn = true;
        return this;
    }
}
