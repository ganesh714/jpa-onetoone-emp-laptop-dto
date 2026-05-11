package com.software.emp_laptop.mapper;

import com.software.emp_laptop.dto.EmployeeDto;
import com.software.emp_laptop.models.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel="spring",  unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmpMapper {

    public List<EmployeeDto> mapEmployeeToEmployeeDtoList(List<Employee> employees);

    public List<Employee>  mapEmployeeDtoToEmployeeList(List<EmployeeDto> employeeDtos);

    Employee toEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> toEmployeeDtos(List<Employee> all);

    EmployeeDto toEmployeeDto(Employee employee);
}
