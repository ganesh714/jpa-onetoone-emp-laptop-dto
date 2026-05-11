package com.software.emp_laptop.mapper;

import com.software.emp_laptop.dto.LaptopDto;
import com.software.emp_laptop.dto.LaptopEmpNameDto;
import com.software.emp_laptop.models.Laptop;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE )
public interface LapMapper {

    Laptop toLaptop(LaptopDto laptopDto);

    List<LaptopDto> toLaptopDtos(List<Laptop> all);

    @Mapping(target = "employee", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    LaptopDto toLaptopDto(Laptop laptop);

    @Mapping(target = "employName", expression = "java(laptop.getEmployee().getEmp_name())")
    LaptopEmpNameDto toLaptopEmpNameDto(Laptop laptop);
}
