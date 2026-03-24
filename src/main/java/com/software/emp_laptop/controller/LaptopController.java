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

import com.software.emp_laptop.dto.LaptopDto;
import com.software.emp_laptop.models.Employee;
import com.software.emp_laptop.models.Laptop;
import com.software.emp_laptop.service.LaptopService;

@CrossOrigin("*")
@RestController
public class LaptopController {
	
	@Autowired
	LaptopService laptopService;
	
	@PostMapping("/laptop")
	public boolean addLaptop(@RequestBody LaptopDto laptopDto) {
		return laptopService.addLaptop(laptopDto);
	}
	
    @GetMapping("/laptops")
    public List<LaptopDto> getAllLaptops() {
        return laptopService.getAllLaptops();
    }

    @GetMapping("/laptop/{id}")
    public LaptopDto getLaptopById(@PathVariable String id) {
        return laptopService.getLaptopById(id);
    }

    @PutMapping("/laptop/{id}")
    public LaptopDto updateLaptop(@PathVariable String id, @RequestBody LaptopDto laptopDto) {
        return laptopService.updateLaptop(id, laptopDto);
    }
    
    @DeleteMapping("/laptop/{id}")
    public String deleteLaptop(@PathVariable String id) {
    	return laptopService.deleteLaptop(id);
    }
	
	@PutMapping("/laptop/{lap_id}/employee/{emp_id}")
	public LaptopDto assignLaptopToEmployee(@PathVariable String lap_id,@PathVariable String emp_id) {
		return laptopService.assignLaptopToEmployee(lap_id, emp_id);
	}
	
	@GetMapping("/laptop/employee/{emp_id}")
	public LaptopDto getLpatopByEmpId(@PathVariable String emp_id) {
		return laptopService.getLaptopByEmpId(emp_id);
	}
}
