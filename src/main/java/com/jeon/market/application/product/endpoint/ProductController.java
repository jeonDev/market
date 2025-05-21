package com.jeon.market.application.product.endpoint;

import com.jeon.market.application.product.service.ProductCompleteCommandService;
import com.jeon.market.application.product.service.ProductRegisterCommandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class ProductController {

    private final ProductRegisterCommandService productRegisterCommandService;
    private final ProductCompleteCommandService productCompleteCommandService;

    public ProductController(ProductRegisterCommandService productRegisterCommandService,
                             ProductCompleteCommandService productCompleteCommandService) {
        this.productRegisterCommandService = productRegisterCommandService;
        this.productCompleteCommandService = productCompleteCommandService;
    }

    @PostMapping("/product/register")
    public ResponseEntity<ProductRegisterResponse> register(@RequestBody ProductRegisterRequest request) {
        Long memberId = 1L; // TODO: 로그인 기능 구현 후
        return ResponseEntity.ok(
                ProductRegisterResponse.from(productRegisterCommandService.register(request.toRequest(memberId)))
        );
    }

    @PatchMapping("/product/complete/{productId}")
    public ResponseEntity<String> complete(@PathVariable("productId") Long productId) {
        Long memberId = 1L; // TODO: 로그인 기능 구현 후.
        productCompleteCommandService.complete(productId, memberId);
        return ResponseEntity.ok("Ok");
    }
}
