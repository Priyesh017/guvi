package com.example.practice.guvi.controller;

import com.example.practice.guvi.dto.ProductRequestDto;
import com.example.practice.guvi.model.mongodb.GuviTask;
import com.example.practice.guvi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public List<GuviTask> getProducts() {
        return productService.getProducts();
    }

    @PostMapping("/products")
    public Integer saveProduct(@RequestBody ProductRequestDto requestDto) {
        return productService.saveProduct(requestDto);
    }
}
