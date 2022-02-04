package com.conatus.conatussb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conatus.conatussb.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	
}
