package com.jeon.market.chatting.application.usecase;

import com.jeon.market.chatting.application.service.ChatRoomService;
import com.jeon.market.chatting.application.usecase.request.ChattingRoomCommand;
import com.jeon.market.chatting.application.usecase.response.ChattingRoomResult;
import com.jeon.market.member.application.domain.Member;
import com.jeon.market.member.application.domain.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ChatRoomUseCase {
    private final MemberRepository memberRepository;
    private final ChatRoomService chattingRoomService;

    public ChatRoomUseCase(MemberRepository memberRepository,
                           ChatRoomService chatRoomService) {
        this.memberRepository = memberRepository;
        this.chattingRoomService = chatRoomService;
    }

    @Transactional
    public ChattingRoomResult execute(ChattingRoomCommand command) {
        // 1. 사용자 존재 여부 체크
        Member member = memberRepository.findById(command.memberId())
                .orElseThrow();
        member.activeMemberCheck();

        Member targetMember = memberRepository.findById(command.targetMemberId())
                .orElseThrow();
        targetMember.activeMemberCheck();

        // 2. 채팅 방 가져오기 or 생성
        var chatRoom = chattingRoomService.chattingRoomCreate(command.chatRoomId(),
                command.chatType(),
                member.getId(),
                targetMember.getId()
        );

        return new ChattingRoomResult(
                chatRoom.getId()
        );
    }
}
