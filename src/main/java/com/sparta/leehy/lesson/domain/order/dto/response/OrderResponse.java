package com.sparta.leehy.lesson.domain.order.dto.response;

import com.sparta.leehy.lesson.global.constants.enums.OrderStatus;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderResponse {

    Long id;

    BigDecimal totalPrice;

    OrderStatus status;
    LocalDateTime createdAt;

    OrderUserResponse users;

    List<OrderProductResponse> products;

    @Getter
    @Builder
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class OrderUserResponse {

        Long id;

        String name;

    }

    @Getter
    @NoArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class OrderProductResponse {
        Long id;
        String name;
        Integer quantity;
        BigDecimal price;
    }
}
