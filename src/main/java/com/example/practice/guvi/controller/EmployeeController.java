package com.example.practice.guvi.controller;

import com.example.practice.guvi.dto.EmployeeRequestDto;
import com.example.practice.guvi.model.mongodb.GuviTask;
import com.example.practice.guvi.model.mysql.Employee;
import com.example.practice.guvi.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @PostMapping("/employees")
    public Integer saveEmployee(@RequestBody @Valid EmployeeRequestDto requestDto) {
        return employeeService.saveEmployee(requestDto);
    }
}
