package com.jeon.market.application.product.endpoint;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ProductController {

    @PostMapping("/product/register")
    public ResponseEntity<String> register() {
        // TODO:..
        return null;
    }
}
