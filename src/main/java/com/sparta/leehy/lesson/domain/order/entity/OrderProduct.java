package com.sparta.leehy.lesson.domain.order.entity;

import com.sparta.leehy.lesson.domain.product.entity.Product;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "order_products")
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    Product product;

    @Column(nullable = false)
    Integer quantity;

    @Column(nullable = false)
    BigDecimal price;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    LocalDateTime createdAt;

    @Column(nullable = false)
    @UpdateTimestamp
    LocalDateTime updatedAt;

    @Builder
    public OrderProduct(
            Order order,
            Product product,
            Integer quantity,
            BigDecimal price
    ) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }
}