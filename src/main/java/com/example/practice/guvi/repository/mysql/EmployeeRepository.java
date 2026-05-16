package com.example.practice.guvi.repository.mysql;

import com.example.practice.guvi.model.mysql.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//<EntityName, Entity's Primary Key datatype>
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
