package com.jeon.market.application.chatting.domain;

import com.jeon.market.application.chatting.domain.type.ChatType;

import java.util.Optional;

public interface ChatRepository {

    ChatRoom roomCreate(ChatType chatType);
    void roomCreate(Long chatRoomId, Long... targetMemberId);
    Optional<ChatRoom> findByMemberIdAndTargetMemberId(Long memberId, Long targetMemberId);
}
