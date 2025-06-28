package com.jeon.market.application.member.endpoint;

import com.jeon.market.application.member.endpoint.request.MemberCreateRequest;
import com.jeon.market.application.member.endpoint.response.MemberCreateResponse;
import com.jeon.market.application.member.service.command.CreateMemberCommandService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MemberController {

    private final CreateMemberCommandService memberService;

    public MemberController(CreateMemberCommandService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/member/create")
    public ResponseEntity<MemberCreateResponse> create(@RequestBody @Valid MemberCreateRequest request) {
        return ResponseEntity.ok(
                MemberCreateResponse.of(
                        memberService.createMember(request.toRequest())
                )
        );
    }

}
