package com.sparta.leehy.lesson.domain.order.service;

import com.sparta.leehy.lesson.domain.order.dto.request.OrderRequest;
import com.sparta.leehy.lesson.domain.order.dto.response.OrderResponse;
import com.sparta.leehy.lesson.domain.order.repository.OrderRepository;
import com.sparta.leehy.lesson.domain.product.entity.Product;
import com.sparta.leehy.lesson.domain.product.repository.ProductRepository;
import com.sparta.leehy.lesson.domain.user.entity.User;
import com.sparta.leehy.lesson.domain.user.repository.UserRepository;
import com.sparta.leehy.lesson.global.exception.DomainExceptionCode;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class OrderService {

    private final UserRepository userRepository;
    private final OrderRepository orderRespository;
    private final ProductRepository productRepository;

//    @Transactional
//    public OrderResponse order(OrderRequest request) {
//        // 1. 사용자 조회
//        User user = userRepository.findById(request.getUserId())
//                .orElseThrow(() -> new ServiceException(DomainExceptionCode.NOT_FOUND_USER));
//
//
//
//
//        // 2주차 3일 실습 확인하기....
//
//        // 5. 응답 DTO로 변환하여 반환
//        return OrderResponse.fromEntity(savedOrder);
    }
}

