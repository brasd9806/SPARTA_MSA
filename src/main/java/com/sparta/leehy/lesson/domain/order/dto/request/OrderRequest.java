package com.sparta.leehy.lesson.domain.order.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderRequest {

    @NotBlank(message = "사용자가 존재하지 않습니다.")
    Long userId;

    @NotEmpty
    List<OrderProduct> products;

    @Getter
    @NoArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class OrderProduct {
        @NotNull
        Long id;  // productId

        @Min(1)
        Integer quantity;
    }

}
