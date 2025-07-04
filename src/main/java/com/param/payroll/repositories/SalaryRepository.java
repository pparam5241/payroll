package com.param.payroll.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.param.payroll.entities.Salary;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long> {

	Optional<Salary> findByEmployeeIdAndSalaryMonth(Long employeeId, String salaryMonth);
	
	List<Salary> findByEmployeeId(Long employeeId);
}