package com.example.practice.guvi.repository.h2;

import com.example.practice.guvi.model.h2.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRespository extends JpaRepository<Product, Integer> {
}
