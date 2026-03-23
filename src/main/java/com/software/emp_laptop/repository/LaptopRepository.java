package com.software.emp_laptop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.software.emp_laptop.models.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, String>{
	
	
	@Query("SELECT l FROM Laptop l WHERE l.employee.emp_id = :id")
    public Laptop getLaptopByEmpId(@Param("id") String id);
}
