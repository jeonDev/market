package com.jeon.market.application.chatting.domain;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ChatMemberId implements Serializable {
    private Long chatRoomId;
    private Long memberId;

    @Override
    public int hashCode() {
        return Objects.hash(chatRoomId, memberId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChatMemberId that)) return false;
        return Objects.equals(chatRoomId, that.chatRoomId) &&
                Objects.equals(memberId, that.memberId);
    }
}
