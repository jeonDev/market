package com.jeon.market.chatting.infrastructure.repository;

import com.jeon.market.chatting.application.domain.ChatMember;
import com.jeon.market.chatting.application.domain.ChatMemberId;
import com.jeon.market.chatting.application.domain.ChatMemberRepository;
import com.jeon.market.chatting.infrastructure.repository.jpa.JpaChatMemberRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ChatMemberRepositoryImpl implements ChatMemberRepository {

    private final JpaChatMemberRepository jpaChatMemberRepository;

    public ChatMemberRepositoryImpl(JpaChatMemberRepository jpaChatMemberRepository) {
        this.jpaChatMemberRepository = jpaChatMemberRepository;
    }

    @Override
    public ChatMember save(ChatMember chatMember) {
        return jpaChatMemberRepository.save(chatMember);
    }

    @Override
    public Optional<ChatMember> findById(ChatMemberId id) {
        return jpaChatMemberRepository.findById(id);
    }

    @Override
    public void delete(ChatMember chatMember) {
        // TODO: soft delete
        jpaChatMemberRepository.delete(chatMember);
    }
}
