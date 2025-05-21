package com.jeon.market.application.product.domain;

import com.jeon.market.application.product.domain.type.ProductStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;

@Getter
@Entity
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "PRODUCT")
@Access(AccessType.FIELD)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private Long id;

    @Column(name = "MEMBER_ID", nullable = false)
    private Long memberId;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "CONTENT", nullable = false, length = 500)
    private String content;

    @Column(name = "PRICE")
    private BigInteger price;

    @Column(name = "VIEW_COUNT")
    private Long viewCount;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private ProductStatus status;

    public static Product createProduct(
            Long memberId,
            String title,
            String content,
            BigInteger price
    ) {
        return Product.builder()
                .memberId(memberId)
                .title(title)
                .content(content)
                .price(price)
                .status(ProductStatus.NEW)
                .build();
    }

    public void writerCheck(Long memberId) {
        if (!this.memberId.equals(memberId)) {
            throw new RuntimeException("등록자가 아님");
        }
    }

    public void transactionComplete() {
        this.status = ProductStatus.COMPLETE;
    }
}
