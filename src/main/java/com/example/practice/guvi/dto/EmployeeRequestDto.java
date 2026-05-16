package com.example.practice.guvi.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class EmployeeRequestDto {
    private Integer id;
    private String name;
    private String email;
}
