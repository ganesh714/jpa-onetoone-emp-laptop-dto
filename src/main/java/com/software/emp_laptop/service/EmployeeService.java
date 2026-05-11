package com.software.emp_laptop.service;

import java.util.List;

import com.software.emp_laptop.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.software.emp_laptop.dto.EmployeeDto;
import com.software.emp_laptop.mapper.EmployeeMapper;
import com.software.emp_laptop.models.Employee;
import com.software.emp_laptop.models.Laptop;
import com.software.emp_laptop.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	EmployeeMapper empmapper;

	@Autowired
	EmpMapper employeeMapper;

	public boolean addEmployee(EmployeeDto employeeDto) {
		if (isEmployeePresent(employeeDto.getEmp_id())) {
			return false;
		}
		employeeRepository.save(employeeMapper.toEmployee(employeeDto));
		return true;
	}

	public List<EmployeeDto> getAllEmployees(){
		return employeeMapper.toEmployeeDtos(employeeRepository.findAll());
	}

	public EmployeeDto getEmployeeById(String id) {
		return employeeMapper.toEmployeeDto(employeeRepository.findById(id).orElse(null));
	}

	public EmployeeDto updateEmployee(String id, EmployeeDto employeeDto) {
		if (isEmployeePresent(id)) {
	        EmployeeDto existing = getEmployeeById(id);

	        if (employeeDto.getEmp_name() != null) {
	            existing.setEmp_name(employeeDto.getEmp_name());
	        }
	        if (employeeDto.getEmp_salary() != 0) {
	            existing.setEmp_salary(employeeDto.getEmp_salary());
	        }
	        if (employeeDto.getEmp_joing_date() != null) {
	            existing.setEmp_joing_date(employeeDto.getEmp_joing_date());
	        }

	        Employee updatedEmployee = employeeRepository.save(employeeMapper.toEmployee(existing));
	        return employeeMapper.toEmployeeDto(updatedEmployee);
	    }
		return null;
	}

	public String deleteEmployee(String id) {
		if (isEmployeePresent(id)) {
			employeeRepository.deleteById(id);
			return "Employee deleted successfully!";
		}
		return "Employee not found!";
	}

	public boolean isEmployeePresent(String id) {
		return employeeRepository.findById(id).isPresent();
	}
}
