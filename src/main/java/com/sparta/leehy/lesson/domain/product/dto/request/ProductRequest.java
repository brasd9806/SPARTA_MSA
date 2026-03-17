package com.sparta.leehy.lesson.domain.product.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequest {

    Long categoryId;

    @NotNull
    String name;

    String description;

    @NotNull
    @Positive // 값을 양수로만 제한
    BigDecimal price;

    @NotNull
    @PositiveOrZero // 값을 양수로 혹은 0으로 제한
    Integer stock;
}
