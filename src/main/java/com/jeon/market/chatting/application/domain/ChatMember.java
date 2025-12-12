package com.jeon.market.chatting.application.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 1:1 채팅
 */

@Getter
@Builder
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


    public void delete() {
        this.useYn = false;
    }

    public ChatMember use() {
        this.useYn = true;
        return this;
    }
}
