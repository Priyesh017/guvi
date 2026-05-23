package com.example.practice.guvi.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class ErrorDetailsDto {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private Object message;
}
