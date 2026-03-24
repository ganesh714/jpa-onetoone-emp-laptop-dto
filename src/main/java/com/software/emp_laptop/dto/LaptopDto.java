package com.software.emp_laptop.dto;

import com.software.emp_laptop.models.Employee;

import lombok.Data;
@Data
public class LaptopDto {
	private String lap_id;
	private String lap_name;
	private String lap_model;
	private String lap_warranty;
	private Employee employee;
}
