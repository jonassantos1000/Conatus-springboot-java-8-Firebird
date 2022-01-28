package com.conatus.conatussb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conatus.conatussb.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
	
	
}
