package com.jeon.market.application.chatting.domain;

import com.jeon.market.application.chatting.domain.type.ChatType;

public interface ChatRepository {

    ChatRoom roomCreate(ChatType chatType);
    void roomCreate(Long chatRoomId, Long... targetMemberId);
    Long findByMemberIdAndTargetMemberId(Long memberId, Long targetMemberId);
}
