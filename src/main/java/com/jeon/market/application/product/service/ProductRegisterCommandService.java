package com.jeon.market.application.product.service;

import com.jeon.market.application.member.domain.type.Grade;
import com.jeon.market.application.member.service.MemberQueryResponse;
import com.jeon.market.application.member.service.MemberQueryService;
import com.jeon.market.application.product.domain.Product;
import com.jeon.market.application.product.domain.ProductRepository;
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

        // 1-1. 회원 등급 확인 (TODO: 어느 위치에서 검증을 해야하나)
        if (member.grade() == Grade.BLACK_LIST) {
            throw new IllegalStateException("블랙리스트 회원");
        }

        // 2. 상품 정보 등록
        Product product = Product.createProduct(member.id(), request.title(), request.content(), request.price());
        productRepository.save(product);

        return ProductRegisterCommandResponse.from(product);
    }


}
