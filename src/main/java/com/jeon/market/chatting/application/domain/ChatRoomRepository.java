package com.jeon.market.chatting.application.domain;

import com.jeon.market.chatting.application.domain.type.ChatType;

import java.util.Optional;

public interface ChatRoomRepository {
    Optional<ChatRoom> findById(Long id);
    ChatRoom save(ChatRoom chatRoom);
    Optional<ChatRoom> isExistsPersonalChatRoom(Long memberId, Long targetMemberId, ChatType chatType, int roomInviteCount);
}
