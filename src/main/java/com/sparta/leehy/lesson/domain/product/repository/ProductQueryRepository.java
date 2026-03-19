package com.sparta.leehy.lesson.domain.product.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sparta.leehy.lesson.domain.product.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.sparta.leehy.lesson.domain.product.entity.QProduct.product;

@Repository
@RequiredArgsConstructor
public class ProductQueryRepository {

    private final JPAQueryFactory queryFactory;

    public List<Product> findProducts(String name, Double minPrice, Double maxPrice) {
        return queryFactory
                .selectFrom(product)  // select * from product
                .where(
                        // 각 조건이 null이면 무시됨
                        name != null ? product.name.contains(name) : null,    // , : AND /  or: OR
                        minPrice != null ? product.price.goe(minPrice) : null, // goe: >=
                        maxPrice != null ? product.price.loe(maxPrice) : null  // loe: <=
                )
                .fetch();
    }
}
