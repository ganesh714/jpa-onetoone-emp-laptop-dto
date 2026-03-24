package com.software.emp_laptop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.software.emp_laptop.dto.EmployeeDto;
import com.software.emp_laptop.models.Employee;
import com.software.emp_laptop.models.Laptop;
import com.software.emp_laptop.service.EmployeeService;

@CrossOrigin("*")
@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("employee")
	public boolean addEmployee(@RequestBody EmployeeDto employeeDto) {
		return employeeService.addEmployee(employeeDto);
	}
	
	@GetMapping("/employees")
	public List<EmployeeDto> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
	
	 @GetMapping("/employee/{id}")
	public EmployeeDto getEmployeeById(@PathVariable String id) {
		return employeeService.getEmployeeById(id);
	}

	@PutMapping("/employee/{id}")
	public EmployeeDto updateEmployee(@PathVariable String id,
									@RequestBody EmployeeDto employeeDto) {
		return employeeService.updateEmployee(id, employeeDto);
	}

	@DeleteMapping("/employee/{id}")
	public String deleteEmployee(@PathVariable String id) {
		employeeService.deleteEmployee(id);
		return "Employee deleted successfully!";
	}
}
