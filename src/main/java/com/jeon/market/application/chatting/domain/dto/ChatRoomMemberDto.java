package com.jeon.market.application.chatting.domain.dto;

import java.util.List;

public record ChatRoomMemberDto(
        Long chatRoomId,
        Long memberId,
        List<Long> sendMemberIdList,
        boolean useYn
) {


}
