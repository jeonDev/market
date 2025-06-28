package com.jeon.market.application.member.endpoint;

import com.jeon.market.application.auth.service.SessionService;
import com.jeon.market.application.member.endpoint.request.MemberReportRequest;
import com.jeon.market.application.member.service.command.response.MemberReportCommandResponse;
import com.jeon.market.application.member.service.command.MemberReportCommandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MemberReportController {

    private final MemberReportCommandService reportCommandService;
    private final SessionService sessionService;

    public MemberReportController(MemberReportCommandService reportCommandService,
                                  SessionService sessionService) {
        this.reportCommandService = reportCommandService;
        this.sessionService = sessionService;
    }

    @PostMapping("/member/report")
    public ResponseEntity<Long> report(@RequestBody MemberReportRequest request) {
        Long memberId = sessionService.getMemberId();
        MemberReportCommandResponse response = reportCommandService.report(request.toRequest(memberId));
        return ResponseEntity.ok(response.id());
    }
}
