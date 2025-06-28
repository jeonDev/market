package com.jeon.market.application.chatting.service.command;

import com.jeon.market.application.chatting.domain.ChatManagerRepository;
import com.jeon.market.application.chatting.domain.dto.ChatRoomMemberDto;
import com.jeon.market.application.chatting.domain.mongo.Chat;
import com.jeon.market.application.chatting.domain.mongo.ChatRepository;
import com.jeon.market.application.chatting.domain.type.MessageType;
import com.jeon.market.application.member.domain.Member;
import com.jeon.market.application.member.domain.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class ChattingCommandService {

    private final ChatRepository chatRepository;
    private final ChatManagerRepository chatManagerRepository;
    private final MemberRepository memberRepository;

    public ChattingCommandService(ChatRepository chatRepository,
                                  ChatManagerRepository chatManagerRepository,
                                  MemberRepository memberRepository) {
        this.chatRepository = chatRepository;
        this.chatManagerRepository = chatManagerRepository;
        this.memberRepository = memberRepository;
    }

    public void send(Long chatRoomId,
                     Long memberId,
                     MessageType messageType,
                     Object message
                     ) {
        // 1. Room 조회
        ChatRoomMemberDto chatRoomMember = chatManagerRepository.findByMemberIdAndRoomId(chatRoomId, memberId)
                .orElseThrow();

        // 2. Member 조회
        Member sendMember = memberRepository.findById(memberId)
                .orElseThrow();

        // 3. 저장
        Chat chat = Chat.builder()
                .chatRoomId(chatRoomMember.getChatRoomId())
                .memberId(sendMember.getId())
                .messageType(messageType)
                .message(message)
                .build();
        chatRepository.save(chat);

        // 4. Event 발생 (채팅 참여자에게 전송)
    }
}
