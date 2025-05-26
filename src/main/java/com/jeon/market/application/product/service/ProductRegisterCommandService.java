package com.jeon.market.application.product.service;

import com.jeon.market.application.member.service.response.MemberQueryResponse;
import com.jeon.market.application.member.service.MemberQueryService;
import com.jeon.market.application.product.domain.Product;
import com.jeon.market.application.product.domain.ProductRepository;
import com.jeon.market.application.product.service.request.ProductRegisterCommandRequest;
import com.jeon.market.application.product.service.response.ProductRegisterCommandResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductRegisterCommandService {

    private final MemberQueryService memberQueryService;
    private final ProductRepository productRepository;

    public ProductRegisterCommandService(MemberQueryService memberQueryService,
                                         ProductRepository productRepository) {
        this.memberQueryService = memberQueryService;
        this.productRepository = productRepository;
    }

    @Transactional
    public ProductRegisterCommandResponse register(ProductRegisterCommandRequest request) {
        // 1. 유효한 고객인지 체크.
        MemberQueryResponse member = memberQueryService.findById(request.memberId());
        member.activeMemberCheck();

        // 2. 상품 정보 등록
        Product product = Product.createProduct(member.id(), request.title(), request.content(), request.price());
        productRepository.save(product);

        return ProductRegisterCommandResponse.from(product);
    }


}
