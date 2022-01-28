package com.conatus.conatussb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conatus.conatussb.entities.Product;
import com.conatus.conatussb.repositories.ProductCustomRepository;

@Service
public class ProductService {

	@Autowired
	ProductCustomRepository customRepository;

	public List<Product> findCustom(Long id, String desricao, String inativo, String limite) {
		return customRepository.findCustomAll(id, desricao, inativo, limite);
	}
}
