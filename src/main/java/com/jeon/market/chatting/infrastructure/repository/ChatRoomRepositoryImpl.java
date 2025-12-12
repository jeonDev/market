package com.jeon.market.chatting.infrastructure.repository;

import com.jeon.market.chatting.application.domain.ChatRoom;
import com.jeon.market.chatting.application.domain.ChatRoomRepository;
import com.jeon.market.chatting.application.domain.type.ChatType;
import com.jeon.market.chatting.infrastructure.repository.jpa.JpaChatRoomRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ChatRoomRepositoryImpl implements ChatRoomRepository {
    private final JpaChatRoomRepository jpaChatRoomRepository;

    public ChatRoomRepositoryImpl(JpaChatRoomRepository jpaChatRoomRepository) {
        this.jpaChatRoomRepository = jpaChatRoomRepository;
    }

    @Override
    public Optional<ChatRoom> findById(Long id) {
        return jpaChatRoomRepository.findById(id);
    }

    @Override
    public ChatRoom save(ChatRoom chatRoom) {
        return jpaChatRoomRepository.save(chatRoom);
    }

    @Override
    public Optional<ChatRoom> isExistsPersonalChatRoom(Long memberId, Long targetMemberId, ChatType chatType, int roomInviteCount) {
        return jpaChatRoomRepository.isExistsPersonalChatRoom(memberId,
                targetMemberId,
                chatType,
                roomInviteCount
        );
    }
}
