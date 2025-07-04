package com.param.payroll.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.param.payroll.dtos.SalaryRequestDto;
import com.param.payroll.entities.Salary;
import com.param.payroll.repositories.SalaryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class SalaryService {

	private final SalaryRepository salaryRepository;

	public Salary insertSalary(SalaryRequestDto dto) {
		var opt = salaryRepository.findByEmployeeIdAndSalaryMonth(dto.getEmployeeId(), dto.getSalaryMonth());
		if (opt.isPresent()) {
			throw new RuntimeException(
					"Salary is already inserted for this month. You can delete the entry and recreate if needed.");
		}
		Salary salary = Salary.builder().employeeId(dto.getEmployeeId()).salary(dto.getSalary())
				.salaryMonth(dto.getSalaryMonth()).build();
		return salaryRepository.save(salary);
	}
	
	public List<Salary> getSalariesByEmployeeId(Long employeeId) {
		return salaryRepository.findByEmployeeId(employeeId);
	}
}