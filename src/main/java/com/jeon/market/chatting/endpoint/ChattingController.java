package com.jeon.market.chatting.endpoint;

import com.jeon.market.auth.application.service.SessionService;
import com.jeon.market.chatting.application.usecase.ChatRoomUseCase;
import com.jeon.market.chatting.application.usecase.ExitChatRoomUseCase;
import com.jeon.market.chatting.endpoint.payload.ChattingCreatePayload;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@Tag(name = "채팅", description = "채팅 관련 API")
public class ChattingController {

    private final SessionService sessionService;
    private final ChatRoomUseCase chatRoomUseCase;
    private final ExitChatRoomUseCase exitChatRoomUseCase;

    public ChattingController(SessionService sessionService,
                              ChatRoomUseCase chatRoomUseCase,
                              ExitChatRoomUseCase exitChatRoomUseCase) {
        this.sessionService = sessionService;
        this.chatRoomUseCase = chatRoomUseCase;
        this.exitChatRoomUseCase = exitChatRoomUseCase;
    }

    @Operation(summary = "채팅방 입장")
    @PostMapping("/chatting/room")
    public ChattingCreatePayload.Response create(@Valid @RequestBody ChattingCreatePayload.Request request) {
        Long memberId = sessionService.getMemberId();
        var result = chatRoomUseCase.execute(request.toRequest(memberId));

        return new ChattingCreatePayload.Response(
                result.chatRoomId()
        );
    }

    @Operation(summary = "채팅방 나가기")
    @DeleteMapping("/chatting/room/{chatRoomId}")
    public void delete(@PathVariable("chatRoomId") Long chatRoomId) {
        Long memberId = sessionService.getMemberId();
        exitChatRoomUseCase.execute(chatRoomId, memberId);
    }
}
