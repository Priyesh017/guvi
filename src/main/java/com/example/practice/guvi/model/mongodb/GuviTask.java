package com.example.practice.guvi.model.mongodb;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@Document(collection = "guvi_tasks")
public class GuviTask {
    @Id
    private Integer id;
    @Field(name = "product_name")
    private String productName;
    @Field(name = "product_price")
    private Double productPrice;
}
