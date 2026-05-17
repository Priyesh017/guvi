package com.example.practice.guvi.service;

import com.example.practice.guvi.dto.ProductRequestDto;
import com.example.practice.guvi.model.mongodb.GuviTask;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.practice.guvi.repository.mongodb.GuviTasksRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final GuviTasksRepository guviTasksRepository;

    public List<GuviTask> getProducts() {
        return guviTasksRepository.findAll();
    }

    public Integer saveProduct(ProductRequestDto requestDto) {
        GuviTask product = GuviTask.builder()
                .id(requestDto.getId())
                .productName(requestDto.getProductName())
                .productPrice(requestDto.getProductPrice())
                .build();

        GuviTask saveProduct = guviTasksRepository.save(product);

        return saveProduct.getId();
    }
}
