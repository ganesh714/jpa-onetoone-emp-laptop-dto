package com.software.emp_laptop.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.software.emp_laptop.dto.LaptopDto;
import com.software.emp_laptop.models.Laptop;

@Component
public class LaptopMapper {
	
	public Laptop toLaptop(LaptopDto laptopDto) {
		
		Laptop laptop = new Laptop();
		laptop.setLap_id(laptopDto.getLap_id());
		laptop.setLap_name(laptopDto.getLap_name());
		laptop.setLap_model(laptopDto.getLap_model());
		laptop.setLap_warranty(laptopDto.getLap_warranty());
		laptop.setEmployee(laptopDto.getEmployee());
		
		return laptop;
	}
	
	public LaptopDto toLaptopDto(Laptop laptop) {
		if (laptop == null) {
			return null;
		}
		
		LaptopDto laptopDto = new LaptopDto();
		laptopDto.setLap_id(laptop.getLap_id());
		laptopDto.setLap_name(laptop.getLap_name());
		laptopDto.setLap_model(laptop.getLap_model());
		laptopDto.setLap_warranty(laptop.getLap_warranty());
		laptopDto.setEmployee(laptop.getEmployee());
		laptopDto.setEmployName(laptop.getEmployee().getEmp_name());
		return laptopDto;
	}
	
	public List<Laptop> toLaptops(List<LaptopDto> dtos) {
		List<Laptop> list = new ArrayList<>();
		for (LaptopDto dto:dtos) {
			Laptop laptop = toLaptop(dto);
			list.add(laptop);
		}
		return list;
	}
	
	public List<LaptopDto> toLaptopDtos(List<Laptop> laptops) {
		
		List<LaptopDto> list = new ArrayList<>();
		for (Laptop laptop : laptops) {
			LaptopDto laptopDto = toLaptopDto(laptop);
			list.add(laptopDto);
		}
		return list;
	}
}
