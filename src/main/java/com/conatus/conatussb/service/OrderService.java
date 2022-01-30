package com.conatus.conatussb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conatus.conatussb.entities.Order;
import com.conatus.conatussb.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository repository;
		
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}

	
	public Order insert(Order obj) {
		return repository.save(obj);	
	}
		
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
}
