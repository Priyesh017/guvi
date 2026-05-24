package com.example.practice.guvi.repository.mysql;

import com.example.practice.guvi.model.mysql.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//<EntityName, Entity's Primary Key datatype>
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // JPA Method Query
    // This method equals to (select * from employee where email = "priyesh@gmail.com")
    public Employee findByEmail(String email);

    // JPA Method Query
    // This method equals to (select * from employee where email IN ("priyesh@gmail.com"))
    public Employee findByEmailIn(List<String> emails);

    // JPA Method Query
    // This method equals to (select * from employee where email = "priyesh@gmail.com" AND name = "priyesh")
    Employee findByEmailAndName(String email, String name);

    // JPA Named Query
    // This method equals to (select * from employee e where e.id = "id")
    @Query(value = "select e from employee e where e.id = :id")
    Employee findByEmployeeId(Integer id);


    // JPA Native Query
    @Query(value = "select * from employee e where e.id = :id", nativeQuery = true)
    Employee getByEmployeeId(Integer id);
}
