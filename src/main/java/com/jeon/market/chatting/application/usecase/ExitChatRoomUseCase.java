package com.jeon.market.chatting.application.usecase;

import com.jeon.market.chatting.domain.ChatMemberId;
import com.jeon.market.chatting.domain.ChatMemberRepository;
import com.jeon.market.chatting.application.service.ChatRoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class ExitChatRoomUseCase {
    private final ChatMemberRepository chatMemberRepository;
    private final ChatRoomService chatRoomService;

    public ExitChatRoomUseCase(ChatMemberRepository chatMemberRepository,
                               ChatRoomService chatRoomService) {
        this.chatMemberRepository = chatMemberRepository;
        this.chatRoomService = chatRoomService;
    }

    @Transactional
    public void execute(Long chatRoomId, Long memberId) {
        // 1. 채팅방 조회
        var id = new ChatMemberId(chatRoomId, memberId);
        var chatMember = chatMemberRepository.findById(id)
                .orElseThrow();

        // 2. 채팅방 나가기
        chatRoomService.delete(chatMember);
    }
}
