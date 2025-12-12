package com.jeon.market.chatting.application.domain;

import java.util.Optional;

public interface ChatMemberRepository {

    ChatMember save(ChatMember chatMember);
    Optional<ChatMember> findById(ChatMemberId id);
    void delete(ChatMember chatMember);

}
