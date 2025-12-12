package com.jeon.market.chatting.application.service;

import com.jeon.market.chatting.application.domain.*;
import com.jeon.market.chatting.application.domain.type.ChatType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Service
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;
    private final ChatMemberRepository chatMemberRepository;

    public ChatRoomService(ChatRoomRepository chatRoomRepository,
                           ChatMemberRepository chatMemberRepository) {
        this.chatRoomRepository = chatRoomRepository;
        this.chatMemberRepository = chatMemberRepository;
    }

    @Transactional
    public ChatRoom chattingRoomCreate(Long chatRoomId,
                                       ChatType chatType,
                                       Long memberId,
                                       Long targetMemberId
    ) {
        if (chatRoomId != null) {
            return chatRoomRepository.findById(chatRoomId)
                    .orElseThrow();
        }

        if (chatType == ChatType.PERSONAL) {
            Optional<ChatRoom> optionalChatRoom = chatRoomRepository.isExistsPersonalChatRoom(memberId, targetMemberId, ChatType.PERSONAL, 2);
            if (optionalChatRoom.isPresent()) {
                return optionalChatRoom.get();
            }
        }

        var chatRoom = ChatRoom.builder()
                .chatType(chatType)
                .build();
        chatRoomRepository.save(chatRoom);

        ChatMember chatMember = this.generateChatMemberEntity(chatRoom.getId(), memberId);
        ChatMember chatTargetMember = this.generateChatMemberEntity(chatRoom.getId(), targetMemberId);

        return chatRoom;
    }

    private ChatMember generateChatMemberEntity(Long chatRoomId, Long memberId) {
        var id = new ChatMemberId(chatRoomId, memberId);
        var entity = ChatMember.builder()
                .id(id)
                .participationDate(LocalDateTime.now())
                .useYn(true)
                .build();
        return chatMemberRepository.save(entity);
    }

    @Transactional
    public void delete(ChatMember chatMember) {
        chatMemberRepository.delete(chatMember);
    }

}
