package com.conatus.conatussb.repositories;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.conatus.conatussb.entities.Order;
import com.conatus.conatussb.entities.OrderItem;

@Repository
@Transactional
public class OrderCustomRepository {
	
	@Autowired
	OrderRepository repo;
	
	public Order insert(Order order) {
		for(OrderItem x : order.getItems()) {
			x.setOrder(order);
		}
		return repo.save(order);
	}	
}
