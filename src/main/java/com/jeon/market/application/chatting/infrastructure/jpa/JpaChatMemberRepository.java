package com.jeon.market.application.chatting.infrastructure.jpa;

import com.jeon.market.application.chatting.domain.ChatMember;
import com.jeon.market.application.chatting.domain.ChatMemberId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaChatMemberRepository extends JpaRepository<ChatMember, ChatMemberId> {
}
