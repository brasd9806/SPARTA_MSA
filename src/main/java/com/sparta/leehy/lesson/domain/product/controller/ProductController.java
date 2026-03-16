package com.sparta.leehy.lesson.domain.product.controller;

import com.sparta.leehy.lesson.domain.product.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // API 요청을 가장 먼저 받는 클래스로 인식 -> API 스팩이 정의 된 곳
@RequiredArgsConstructor
@RequestMapping("api/products")
public class ProductController {

//    private final ProductService productService;

    // /api/products/1
    @GetMapping("{id}")
    public Product findById(@PathVariable Long id) {
        return Product.builder().build();
    }

    // list로 받고 싶을 때
    // API [GET] /api/products?name="전화기"
    @GetMapping
    public List<Product> searchProducts(@RequestParam(name = "name") String name) {
        return List.of();
    }

    // 상태코드 201 로 받아야함 post는
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // <- HTTP 상태코드 지정이 가능하다.! (201)
    public Product create(@RequestBody Product product) {
        return Product.builder().build();
    }

    @PutMapping("{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        return Product.builder().build();
    }

    // 상태코드 204로 받아야함 delete는
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    public void delete(@PathVariable Long id) {
        return;
    }

}
