package com.software.emp_laptop.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.software.emp_laptop.dto.EmployeeDto;
import com.software.emp_laptop.models.Employee;

@Component
public class EmployeeMapper {
	
	public Employee toEmployee(EmployeeDto employeeDto) {
		
		Employee employee = new Employee();
		employee.setEmp_id(employeeDto.getEmp_id());
		employee.setEmp_joing_date(employeeDto.getEmp_joing_date());
		employee.setEmp_name(employeeDto.getEmp_name());
		employee.setEmp_salary(employeeDto.getEmp_salary());
		return employee;
	}
	
	public EmployeeDto toEmployeeDto(Employee employee) {
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setEmp_id(employee.getEmp_id());
		employeeDto.setEmp_joing_date(employee.getEmp_joing_date());
		employeeDto.setEmp_name(employee.getEmp_name());
		employeeDto.setEmp_salary(employee.getEmp_salary());
		return employeeDto;
	}
	
	public List<Employee> toEmployees(List<EmployeeDto> dtos) {
		List<Employee> list = new ArrayList<>();
		for (EmployeeDto dto : dtos) {
			Employee employee = toEmployee(dto);
			list.add(employee);
		}
		return list;
	}
	
	public List<EmployeeDto> toEmployeeDtos(List<Employee> employees) {
		List<EmployeeDto> list = new ArrayList<>();
		for (Employee employee : employees) {
			EmployeeDto employeeDto = toEmployeeDto(employee);
			list.add(employeeDto);
		}
		return list;
	}
}
