package com.sparta.leehy.lesson.domain.order.controller;

import com.sparta.leehy.lesson.domain.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService OrderService;

//    @PostMapping
//    public ApiResponse<Void> placeOrder(@Valid @RequestBody OrderRequest request) {
//        OrderService.placeOrder(request);
//        return ApiResponse.success();
//    }
}