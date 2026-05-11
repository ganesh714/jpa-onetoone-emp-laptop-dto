package com.software.emp_laptop.service;

import java.util.List;

import com.software.emp_laptop.mapper.LapMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.software.emp_laptop.dto.EmployeeDto;
import com.software.emp_laptop.dto.LaptopDto;
import com.software.emp_laptop.mapper.EmployeeMapper;
import com.software.emp_laptop.mapper.LaptopMapper;
import com.software.emp_laptop.models.Employee;
import com.software.emp_laptop.models.Laptop;
import com.software.emp_laptop.repository.LaptopRepository;

@Service
public class LaptopService {
	
	@Autowired
	LaptopRepository laptopRepository;
	@Autowired
	EmployeeService employeeService;
	@Autowired
    LapMapper laptopMapper;
	@Autowired
	EmployeeMapper employeeMapper;

	Logger logger = LoggerFactory.getLogger(LaptopService.class);

	public boolean addLaptop(LaptopDto laptopDto) {

		logger.info("new laptop ready to add " + laptopDto);

		if (isLaptopPresent(laptopDto.getLap_id())) {
			logger.info("Laptop already exists so unable to add laptop" + laptopDto.getLap_id());
			return false;
		}

		logger.info("Adding laptop " + laptopDto.getLap_id());
		laptopRepository.save(laptopMapper.toLaptop(laptopDto));
		return true;
	}
	
	public List<LaptopDto> getAllLaptops(){
		return laptopMapper.toLaptopDtos(laptopRepository.findAll());
	}
	
	public LaptopDto getLaptopById(String id) {
		return laptopMapper.toLaptopDto(laptopRepository.findById(id).orElse(null));
	}
	
	
	public LaptopDto updateLaptop(String id, LaptopDto laptopDto) {
		if (isLaptopPresent(id)) {
	        LaptopDto existing = getLaptopById(id);
	        
	        if (laptopDto.getLap_name() != null) {
	            existing.setLap_name(laptopDto.getLap_name());
	        }
	        if (laptopDto.getLap_model() != null) {
	            existing.setLap_model(laptopDto.getLap_model());
	        }
	        if (laptopDto.getLap_warranty() != null) {
	            existing.setLap_warranty(laptopDto.getLap_warranty());
	        }
	        
	        Laptop updatedLaptop = laptopRepository.save(laptopMapper.toLaptop(existing));
	        return laptopMapper.toLaptopDto(updatedLaptop);
	    }
		
		return null;
	}
	
	public String deleteLaptop(String id) {
	    if (isLaptopPresent(id)) {
	        laptopRepository.deleteById(id);
	        return "Laptop deleted successfully!";
	    }
	    return "Laptop not found!";
	}
	
	public LaptopDto assignLaptopToEmployee(String lap_id, String emp_id) { //assignLaptopToEmployee
		LaptopDto laptopDto= getLaptopById(lap_id);
		EmployeeDto employeeDto = employeeService.getEmployeeById(emp_id);
		laptopDto.setEmployee(employeeMapper.toEmployee(employeeDto));
		Laptop savedLaptop =  laptopRepository.save(laptopMapper.toLaptop(laptopDto));
		return laptopMapper.toLaptopDto(savedLaptop);
	}
	
	public LaptopDto getLaptopByEmpId(String id) {
		return laptopMapper.toLaptopDto(laptopRepository.getLaptopByEmpId(id));
	}
	
	public boolean isLaptopPresent(String id) {
		return laptopRepository.findById(id).isPresent();
	}
	
	
}
