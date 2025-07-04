package com.param.payroll.dtos;

import lombok.Data;

@Data
public class SalaryRequestDto {
	private Long employeeId;
	private Double salary;
	private String salaryMonth;
}