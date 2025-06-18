package com.jeon.market.application.chatting.endpoint;

import com.jeon.market.application.auth.service.SessionService;
import com.jeon.market.application.chatting.endpoint.request.ChattingCreateRequest;
import com.jeon.market.application.chatting.endpoint.response.ChattingCreateResponse;
import com.jeon.market.application.chatting.service.ChattingRoomCommandService;
import com.jeon.market.application.chatting.service.response.ChattingRoomCreateCommandResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChattingController {

    private final SessionService sessionService;
    private final ChattingRoomCommandService chattingRoomCommandService;

    public ChattingController(SessionService sessionService,
                              ChattingRoomCommandService chattingRoomCommandService) {
        this.sessionService = sessionService;
        this.chattingRoomCommandService = chattingRoomCommandService;
    }

    @PostMapping("/chatting/room")
    public ResponseEntity<ChattingCreateResponse> create(@Valid @RequestBody ChattingCreateRequest request) {
        Long memberId = sessionService.getMemberId();
        ChattingRoomCreateCommandResponse response = chattingRoomCommandService.create(request.toRequest(memberId));

        return ResponseEntity.ok(
                ChattingCreateResponse.of(response.chatRoomId())
        );
    }

    @DeleteMapping("/chatting/room/{chatRoomId}")
    public ResponseEntity<Boolean> delete(@PathVariable("chatRoomId") Long chatRoomId) {
        Long memberId = sessionService.getMemberId();
        chattingRoomCommandService.delete(chatRoomId, memberId);
        return ResponseEntity.ok(true);
    }
}
