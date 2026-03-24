package com.software.emp_laptop.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EmployeeDto {
	private String emp_id;
	private String emp_name;
	private int emp_salary;
	private LocalDate emp_joing_date;
}
