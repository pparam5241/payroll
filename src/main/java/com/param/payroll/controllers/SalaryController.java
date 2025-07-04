package com.param.payroll.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.param.payroll.dtos.SalaryRequestDto;
import com.param.payroll.entities.Salary;
import com.param.payroll.services.SalaryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/salary")
@Slf4j
@RequiredArgsConstructor
public class SalaryController {
	private final SalaryService salaryService;

	@GetMapping
	public ResponseEntity<List<Salary>> getSalariesByEmployee(@RequestParam Long employeeId) {
		return ResponseEntity.ok(salaryService.getSalariesByEmployeeId(employeeId));
	}
	
	@PostMapping
	public ResponseEntity<Salary> createSalaryIfNotExists(@RequestBody SalaryRequestDto dto) {
		return ResponseEntity.ok(salaryService.insertSalary(dto));
	}
}