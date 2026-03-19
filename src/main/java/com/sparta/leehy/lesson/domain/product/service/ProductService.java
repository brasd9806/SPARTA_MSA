package com.sparta.leehy.lesson.domain.product.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sparta.leehy.lesson.domain.product.dto.reponse.ProductResponse;
import com.sparta.leehy.lesson.domain.product.dto.request.ProductRequest;
import com.sparta.leehy.lesson.domain.product.entity.Product;
import com.sparta.leehy.lesson.domain.product.mapper.ProductMapper;
import com.sparta.leehy.lesson.domain.product.repository.ProductRepository;
import com.sparta.leehy.lesson.global.exception.DomainException;
import com.sparta.leehy.lesson.global.exception.DomainExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.sparta.leehy.lesson.domain.product.entity.QProduct.product;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    private final JPAQueryFactory queryFactory;

    public Page<Product> getAllProducts(String name, Pageable pageable) {

        // 1. 실제 데이터 가져오기 (offset과 limit 적용)
        List<Product> content = queryFactory
                .selectFrom(product)
                .where(
                        name != null ? product.name.contains(name) : null
                ) // 이름 검색 조건 (선택)
                .offset(pageable.getOffset()) // "몇 번째부터?"
                .limit(pageable.getPageSize()) // "몇 개나?"
                .fetch();

        // 2. 전체 개수 가져오기 (아까 배운 fetchCount)
        Long total = queryFactory
                .select(product.count())
                .from(product)
                .where(
                        name != null ? product.name.contains(name) : null
                )
                .fetchOne();

        // 3. Spring Data의 PageImpl 객체로 감싸서 반환
        return new PageImpl<>(content, pageable, total);
    }

    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new DomainException(DomainExceptionCode.NOT_FOUND_PRODUCT));

        ProductResponse response = productMapper.toProductResponse(product);

        return response;
    }

    public ProductResponse create(ProductRequest request) {

        Product product = productRepository.save(productMapper.toEntity(request));

        return productMapper.toProductResponse(product);

    }

    public ProductResponse update(Long id, ProductRequest request) {

        Product product = productRepository.save(productMapper.toEntity(request));

        return productMapper.toProductResponse(product);
    }

    public void deleteById(Long id) {
        // 상품이 존재하는지 확인
        if (!productRepository.existsById(id)) {
            throw new DomainException(DomainExceptionCode.NOT_FOUND_PRODUCT);
        }

        productRepository.deleteById(id);
    }
}
