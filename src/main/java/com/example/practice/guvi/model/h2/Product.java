package com.example.practice.guvi.model.h2;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "Product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Product {
    @Column(name = "id", nullable = false)
    @Id
    private Integer id;
    @Column(name = "ProductName")
    private String productName;
    @Column(name = "Price")
    private String productPrice;
}
