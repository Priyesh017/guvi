package com.example.practice.guvi.service;

import com.example.practice.guvi.dto.EmployeeRequestDto;
import com.example.practice.guvi.model.mongodb.GuviTask;
import com.example.practice.guvi.model.mysql.Employee;
import com.example.practice.guvi.repository.mongodb.GuviTasksRepository;
import com.example.practice.guvi.repository.mysql.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final GuviTasksRepository guviTasksRepository;

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    // Use wrapper class when playing with objects
    public Integer saveEmployee(EmployeeRequestDto requestDto) {
         Employee employee = Employee.builder().id(requestDto.getId())
                .name(requestDto.getName())
                .email(requestDto.getEmail())
                .build();

         // Saving the employee object into employee repository
         Employee savedEmployee = employeeRepository.save(employee);


        //employeeRepository.saveAll();

         return savedEmployee.getId();
    }
}
