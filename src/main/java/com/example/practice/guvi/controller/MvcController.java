package com.example.practice.guvi.controller;

import com.example.practice.guvi.dto.EmployeeRequestDto;
import com.example.practice.guvi.model.mysql.Employee;
import com.example.practice.guvi.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MvcController {

    private final EmployeeService employeeService;

    @GetMapping("/employee-list")
    public String getEmployees(Model model) {
        model.addAttribute("employeeList", employeeService.getEmployees());
        return "employeeList";
    }

    @GetMapping("/f-employee")
    public String getFEmployee() {
        return "redirect:/employee-list"; // change the addressbar value and replace it with the path given in the redirect
    }

    @GetMapping("/save-employee")
    public String showEmployeeForm(Model model) {
        model.addAttribute("employee", new EmployeeRequestDto());
        return "saveEmployee";
    }

    @PostMapping("/save-employee")
    public String saveEmployeeForm(@Valid @ModelAttribute("employee") EmployeeRequestDto requestDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "saveEmployee";
        }
        employeeService.saveEmployee(requestDto);
        return "redirect:/employee-list";
    }
}
