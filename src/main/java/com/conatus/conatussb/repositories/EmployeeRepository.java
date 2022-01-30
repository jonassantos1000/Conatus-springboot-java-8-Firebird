package com.conatus.conatussb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conatus.conatussb.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	
}
