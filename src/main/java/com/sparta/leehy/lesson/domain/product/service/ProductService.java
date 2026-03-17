package com.sparta.leehy.lesson.domain.product.service;

import com.sparta.leehy.lesson.domain.product.dto.reponse.ProductResponse;
import com.sparta.leehy.lesson.domain.product.dto.request.ProductRequest;
import com.sparta.leehy.lesson.domain.product.entity.Product;
import com.sparta.leehy.lesson.domain.product.repository.ProductRepository;
import com.sparta.leehy.lesson.global.exception.DomainException;
import com.sparta.leehy.lesson.global.exception.DomainExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductResponse> getAllProducts() {
        return List.of();
    }

    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new DomainException(DomainExceptionCode.NOT_FOUND_PRODUCT));

        return ProductResponse.builder().build();
    }

    public ProductResponse create(ProductRequest request) {
        return ProductResponse.builder().build();
    }

    public ProductResponse update(Long id, ProductRequest request) {
        return ProductResponse.builder().build();
    }

    public void deleteById(Long id) {

    }
}
