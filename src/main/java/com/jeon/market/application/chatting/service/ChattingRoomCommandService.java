package com.jeon.market.application.chatting.service;

import com.jeon.market.application.chatting.domain.ChatManagerRepository;
import com.jeon.market.application.chatting.service.request.ChattingRoomCreateCommandRequest;
import com.jeon.market.application.chatting.service.response.ChattingRoomCreateCommandResponse;
import com.jeon.market.application.member.domain.Member;
import com.jeon.market.application.member.domain.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
public class ChattingRoomCommandService {

    private final ChatManagerRepository chatRepository;
    private final MemberRepository memberRepository;

    public ChattingRoomCommandService(ChatManagerRepository chatRepository,
                                      MemberRepository memberRepository) {
        this.chatRepository = chatRepository;
        this.memberRepository = memberRepository;
    }

    @Transactional
    public ChattingRoomCreateCommandResponse create(ChattingRoomCreateCommandRequest request) {
        // 1. 사용자 존재 여부 체크
        Member member = memberRepository.findById(request.memberId())
                .orElseThrow();
        Member targetMember = memberRepository.findById(request.targetMemberId())
                .orElseThrow();

        // 2. 방 생성
        Long chatRoomId = request.chatRoomId() != null
                ? request.chatRoomId()
                : chatRepository.roomCreate(request.chatType(), member.getId(), targetMember.getId())
                        .getId();

        return ChattingRoomCreateCommandResponse.of(
                chatRoomId
        );
    }

    @Transactional
    public void delete(Long chatRoomId, Long memberId) {
        chatRepository.delete(chatRoomId, memberId);
    }

}
