package com.example.practice.guvi.dto;

import com.example.practice.guvi.validations.annotations.NoSpaces;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class EmployeeRequestDto {
    @NotNull(message = "Employee ID can't be null")
    @Min(value = 0, message = "Minimum value should be greater than or equal to zero")
    private Integer id;
    @NotNull(message = "Employee name can't be null")
    @NotEmpty(message = "Employee name can't be empty")
    @NoSpaces(message = "Name should not have empty spaces")
    private String name;
    @Email(message = "It should be an email id")
    private String email;
}
