package com.jeon.market.application.chatting.infrastructure.jpa;

import com.jeon.market.application.chatting.domain.ChatMember;
import com.jeon.market.application.chatting.domain.ChatMemberId;
import com.jeon.market.application.chatting.domain.dto.ChatRoomMemberDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface JpaChatMemberRepository extends JpaRepository<ChatMember, ChatMemberId> {
    // TODO: 쿼리 수정..
    @Query(value = """
        SELECT new com.jeon.market.application.chatting.domain.dto.ChatRoomMemberDto(
               CM.id.chatRoomId,
               :memberId,
               collect(CM.id.memberId),
               true
                )
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
