package com.example.expenseclaim_api.repo;

import com.example.expenseclaim_api.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
