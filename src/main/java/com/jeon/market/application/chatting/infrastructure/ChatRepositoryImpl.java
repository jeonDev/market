package com.jeon.market.application.chatting.infrastructure;

import com.jeon.market.application.chatting.domain.ChatMember;
import com.jeon.market.application.chatting.domain.ChatMemberId;
import com.jeon.market.application.chatting.domain.ChatRepository;
import com.jeon.market.application.chatting.domain.ChatRoom;
import com.jeon.market.application.chatting.domain.type.ChatType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Repository
public class ChatRepositoryImpl implements ChatRepository {

    private final JpaChatMemberRepository jpaChatMemberRepository;
    private final JpaChatRoomRepository jpaChatRoomRepository;

    public ChatRepositoryImpl(JpaChatMemberRepository jpaChatMemberRepository,
                              JpaChatRoomRepository jpaChatRoomRepository) {
        this.jpaChatMemberRepository = jpaChatMemberRepository;
        this.jpaChatRoomRepository = jpaChatRoomRepository;
    }

    @Override
    @Transactional
    public ChatRoom roomCreate(ChatType chatType) {
        return jpaChatRoomRepository.save(ChatRoom.create(chatType));
    }

    @Override
    @Transactional
    public void roomCreate(Long chatRoomId, Long... targetMemberId) {
        List<ChatMember> list = Arrays.stream(targetMemberId)
                .map(item -> {
                    ChatMemberId chatMemberId = new ChatMemberId(chatRoomId, item);
                    return ChatMember.create(chatMemberId);
                })
                .toList();

        jpaChatMemberRepository.saveAll(list);
    }
}
