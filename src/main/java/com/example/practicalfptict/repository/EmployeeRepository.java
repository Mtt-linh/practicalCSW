package com.example.practicalfptict.repository;

import com.example.practicalfptict.jpa.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
