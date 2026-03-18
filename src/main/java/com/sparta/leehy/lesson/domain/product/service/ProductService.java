package com.sparta.leehy.lesson.domain.product.service;

import com.sparta.leehy.lesson.domain.product.dto.reponse.ProductResponse;
import com.sparta.leehy.lesson.domain.product.dto.request.ProductRequest;
import com.sparta.leehy.lesson.domain.product.entity.Product;
import com.sparta.leehy.lesson.domain.product.mapper.ProductMapper;
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
    private final ProductMapper productMapper;

    public List<ProductResponse> getAllProducts() {
        return List.of();
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
