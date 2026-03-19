package com.sparta.leehy.lesson.domain.order.service;

import com.sparta.leehy.lesson.domain.order.repository.OrderRepository;
import com.sparta.leehy.lesson.domain.product.repository.ProductRepository;
import com.sparta.leehy.lesson.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
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
//    }
}

