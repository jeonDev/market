package com.jeon.market.application.chatting.service;

import com.jeon.market.application.chatting.domain.ChatRepository;
import com.jeon.market.application.chatting.domain.type.ChatType;
import com.jeon.market.application.chatting.service.request.ChattingRoomCreateCommandRequest;
import com.jeon.market.application.chatting.service.response.ChattingRoomCreateCommandResponse;
import com.jeon.market.application.member.service.MemberQueryService;
import com.jeon.market.application.member.service.response.MemberQueryResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class ChattingRoomCommandService {

    private final ChatRepository chatRepository;
    private final MemberQueryService memberQueryService;

    public ChattingRoomCommandService(ChatRepository chatRepository,
                                      MemberQueryService memberQueryService) {
        this.chatRepository = chatRepository;
        this.memberQueryService = memberQueryService;
    }

    @Transactional
    public ChattingRoomCreateCommandResponse create(ChattingRoomCreateCommandRequest request) {
        // 1. 사용자 존재 여부 체크
        MemberQueryResponse member = memberQueryService.findById(request.memberId());
        MemberQueryResponse targetMember = memberQueryService.findById(request.targetMemberId());

        // 2. 방 존재 여부 체크 (PERSONAL)
        if (request.chatType() == ChatType.PERSONAL) {
            Long roomId = chatRepository.findByMemberIdAndTargetMemberId(member.id(), targetMember.id());
            if (roomId != null) return ChattingRoomCreateCommandResponse.of(roomId);
        }

        // 3. 방 생성
        Long chatRoomId = chatRepository.roomCreate(request.chatType())
                .getId();
        chatRepository.roomCreate(chatRoomId, member.id(), targetMember.id());

        return ChattingRoomCreateCommandResponse.of(
                chatRoomId
        );
    }
}
