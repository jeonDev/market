package com.jeon.market.application.product.endpoint;

import com.jeon.market.application.auth.service.SessionService;
import com.jeon.market.application.product.endpoint.request.ProductRegisterRequest;
import com.jeon.market.application.product.endpoint.response.ProductRegisterResponse;
import com.jeon.market.application.product.service.ProductCompleteCommandService;
import com.jeon.market.application.product.service.ProductRegisterCommandService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class ProductController {

    private final SessionService sessionService;
    private final ProductRegisterCommandService productRegisterCommandService;
    private final ProductCompleteCommandService productCompleteCommandService;

    public ProductController(SessionService sessionService,
                             ProductRegisterCommandService productRegisterCommandService,
                             ProductCompleteCommandService productCompleteCommandService) {
        this.sessionService = sessionService;
        this.productRegisterCommandService = productRegisterCommandService;
        this.productCompleteCommandService = productCompleteCommandService;
    }

    @PostMapping("/product/register")
    public ResponseEntity<ProductRegisterResponse> register(@RequestBody @Valid ProductRegisterRequest request) {
        Long memberId = sessionService.getMemberId();
        return ResponseEntity.ok(
                ProductRegisterResponse.from(productRegisterCommandService.register(request.toRequest(memberId)))
        );
    }

    @PatchMapping("/product/complete/{productId}")
    public ResponseEntity<String> complete(@PathVariable("productId") Long productId) {
        Long memberId = sessionService.getMemberId();
        productCompleteCommandService.complete(productId, memberId);
        return ResponseEntity.ok("Ok");
    }
}
