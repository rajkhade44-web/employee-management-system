package com.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.entity.Employee;
import java.util.Optional;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
    Optional<Employee> findByEmployeeCode(String employeeCode);
}
