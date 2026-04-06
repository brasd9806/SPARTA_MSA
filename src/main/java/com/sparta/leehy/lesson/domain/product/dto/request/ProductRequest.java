package com.sparta.leehy.lesson.domain.product.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

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


    List<OptionRequest> options;

    @Getter
    @Builder
    @AllArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class OptionRequest {

        String name;

        BigDecimal additionalPrice;

        Integer stock;
    }
}
