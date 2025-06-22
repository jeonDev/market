package com.jeon.market.application.chatting.domain;

import com.jeon.market.application.chatting.domain.dto.ChatRoomMemberDto;
import com.jeon.market.application.chatting.domain.type.ChatType;

import java.util.Optional;

public interface ChatManagerRepository {

    ChatRoom roomCreate(ChatType chatType, Long... targetMemberId);
    void delete(Long chatRoomId, Long memberId);
    Optional<ChatRoomMemberDto> findByMemberIdAndRoomId(Long memberId, Long chatRoomId);
}
