package com.sparta.leehy.lesson.domain.product.mapper;

import com.sparta.leehy.lesson.domain.product.dto.reponse.ProductResponse;
import com.sparta.leehy.lesson.domain.product.dto.request.ProductRequest;
import com.sparta.leehy.lesson.domain.product.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    //    @Mapping(target = "name", source = "name")
    ProductResponse toProductResponse(Product product);

    //    @Mapping(target = "name", source = "name")
    Product toEntity(ProductRequest product);

}
