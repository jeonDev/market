package com.jeon.market.application.chatting.infrastructure.jpa;

import com.jeon.market.application.chatting.domain.ChatRoom;
import com.jeon.market.application.chatting.domain.type.ChatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface JpaChatRoomRepository extends JpaRepository<ChatRoom, Long> {

    @Query("""
        SELECT CR
          FROM ChatRoom CR
          JOIN FETCH ChatMember CM
            ON CR.id = CM.id.chatRoomId
           AND CM.id.memberId IN (:memberId, :targetMemberId)
         WHERE CR.chatType = :chatType
         GROUP BY CR.id
        HAVING COUNT(CR.id) = :roomCount
    """)
    Optional<ChatRoom> isExistsRoomMember(Long memberId,
                                          Long targetMemberId,
                                          ChatType chatType,
                                          Integer roomCount);
}
