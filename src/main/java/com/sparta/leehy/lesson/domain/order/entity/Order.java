package com.sparta.leehy.lesson.domain.order.entity;

import com.sparta.leehy.lesson.domain.user.entity.User;
import com.sparta.leehy.lesson.global.constants.enums.OrderStatus;
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
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    // fetch = FetcyType.LAZY => 주문 정보를 조회할 때 사용자 정보까지 바로 가져오지 않고, 실제로 사용할 때만 가져오겠다는 뜻
    @ManyToOne(fetch = FetchType.LAZY) // 여러 개의 주문(Many)은 한 명의 사용자(One)에게 속한다
    @JoinColumn(name = "user_id", nullable = false)
    User user;

    @Column(nullable = false)
    BigDecimal totalPrice;

    @Enumerated(EnumType.STRING) // Enum 값을 DB에 저장할 때 이름(문자열) 그대로 저장하겠다
    @Column(nullable = false, length = 20)
    OrderStatus status;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    LocalDateTime createdAt;

    @Column(nullable = false)
    @UpdateTimestamp
    LocalDateTime updatedAt;

    @Builder
    public Order(
            User user,
            BigDecimal totalPrice,
            OrderStatus status
    ) {
        this.user = user;
        this.totalPrice = totalPrice;
        this.status = status;
    }

}