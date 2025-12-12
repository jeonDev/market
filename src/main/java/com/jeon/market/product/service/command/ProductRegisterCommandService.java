package com.jeon.market.product.service.command;

import com.jeon.market.member.application.domain.Member;
import com.jeon.market.member.application.domain.MemberRepository;
import com.jeon.market.product.domain.Product;
import com.jeon.market.product.domain.ProductRepository;
import com.jeon.market.product.service.command.request.ProductRegisterCommandRequest;
import com.jeon.market.product.service.command.response.ProductRegisterCommandResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductRegisterCommandService {

    private final ProductRepository productRepository;
    private final MemberRepository memberRepository;

    public ProductRegisterCommandService(ProductRepository productRepository,
                                         MemberRepository memberRepository) {
        this.productRepository = productRepository;
        this.memberRepository = memberRepository;
    }

    @Transactional
    public ProductRegisterCommandResponse register(ProductRegisterCommandRequest request) {
        // 1. 유효한 고객인지 체크.
        Member member = memberRepository.findById(request.memberId())
                .orElseThrow();
        member.activeMemberCheck();

        // 2. 상품 정보 등록
        Product product = Product.createProduct(member.getId(), request.title(), request.content(), request.price());
        productRepository.save(product);

        return ProductRegisterCommandResponse.from(product);
    }


}
