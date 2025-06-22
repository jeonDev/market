package com.jeon.market.application.chatting.infrastructure;

import com.jeon.market.application.chatting.domain.ChatMember;
import com.jeon.market.application.chatting.domain.ChatMemberId;
import com.jeon.market.application.chatting.domain.ChatManagerRepository;
import com.jeon.market.application.chatting.domain.ChatRoom;
import com.jeon.market.application.chatting.domain.type.ChatType;
import com.jeon.market.application.chatting.infrastructure.jpa.JpaChatMemberRepository;
import com.jeon.market.application.chatting.infrastructure.jpa.JpaChatRoomRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class ChatManagerRepositoryImpl implements ChatManagerRepository {

    private final JpaChatMemberRepository jpaChatMemberRepository;
    private final JpaChatRoomRepository jpaChatRoomRepository;

    public ChatManagerRepositoryImpl(JpaChatMemberRepository jpaChatMemberRepository,
                                     JpaChatRoomRepository jpaChatRoomRepository) {
        this.jpaChatMemberRepository = jpaChatMemberRepository;
        this.jpaChatRoomRepository = jpaChatRoomRepository;
    }

    @Override
    @Transactional
    public ChatRoom roomCreate(ChatType chatType, Long... memberIds) {
        if (chatType == ChatType.PERSONAL) {
            Optional<ChatRoom> optionalChatRoom = this.isExistsPersonalChatRoom(memberIds);
            if (optionalChatRoom.isPresent()) {
                return optionalChatRoom.get();
            }
        }

        ChatRoom chatRoom = jpaChatRoomRepository.save(ChatRoom.create(chatType));

        List<ChatMember> list = Arrays.stream(memberIds)
                .map(item -> {
                    ChatMemberId chatMemberId = new ChatMemberId(chatRoom.getId(), item);
                    return jpaChatMemberRepository.findById(chatMemberId)
                            .orElse(ChatMember.create(chatMemberId))
                            .use();
                })
                .toList();

        jpaChatMemberRepository.saveAll(list);

        return chatRoom;
    }

    private Optional<ChatRoom> isExistsPersonalChatRoom(Long[] memberIds) {
        Long memberId = memberIds[0];
        Long targetMemberId = memberIds[1];
        return jpaChatRoomRepository.isExistsRoomMember(memberId, targetMemberId, ChatType.PERSONAL, 2);
    }

    @Override
    @Transactional
    public void delete(Long chatRoomId, Long memberId) {
        jpaChatMemberRepository.findById(new ChatMemberId(chatRoomId, memberId))
                .orElseThrow()
                .delete();
    }
}
