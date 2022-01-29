package com.conatus.conatussb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conatus.conatussb.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
