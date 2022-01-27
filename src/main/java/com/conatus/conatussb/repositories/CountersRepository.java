package com.conatus.conatussb.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.conatus.conatussb.entities.Counters;

public interface CountersRepository extends JpaRepository<Counters, Long>{
	
	
}
