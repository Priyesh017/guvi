package com.example.practice.guvi.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class ProductRequestDto {
    private Integer id;
    private String productName;
    private Double productPrice;
}

