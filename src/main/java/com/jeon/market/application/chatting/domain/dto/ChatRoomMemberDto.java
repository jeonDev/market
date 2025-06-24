package com.jeon.market.application.chatting.domain.dto;

import java.util.List;

public interface ChatRoomMemberDto {
    Long getChatRoomId();
    Long getMemberId();
    List<Long> getSendMemberIdList();
    boolean getUseYn();

}
