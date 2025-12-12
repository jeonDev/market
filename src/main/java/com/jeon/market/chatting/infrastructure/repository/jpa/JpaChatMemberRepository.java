package com.jeon.market.chatting.infrastructure.repository.jpa;

import com.jeon.market.chatting.application.domain.ChatMember;
import com.jeon.market.chatting.application.domain.ChatMemberId;
import com.jeon.market.chatting.application.domain.dto.ChatRoomMemberDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface JpaChatMemberRepository extends JpaRepository<ChatMember, ChatMemberId> {

    @Query(value = """
        SELECT CM.id.chatRoomId,
               :memberId,
               collect(CM.id.memberId),
               true
          FROM ChatRoom CR
          JOIN FETCH ChatMember CM
            ON CR.id = CM.id.chatRoomId
         WHERE CM.id.memberId <> :memberId
           AND CR.id = :chatRoomId
         GROUP BY CM.id.chatRoomId
    """)
    Optional<ChatRoomMemberDto> findBySendChatRoom(Long memberId,
                                                   Long chatRoomId);
}
