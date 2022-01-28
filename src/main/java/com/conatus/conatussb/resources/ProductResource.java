package com.conatus.conatussb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.conatus.conatussb.entities.Product;
import com.conatus.conatussb.service.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	@Autowired
	ProductService service;
	
	
	@GetMapping(value="/custom")
	public ResponseEntity<List<Product>> findByAll(
			@RequestParam(value="id", required=false) Long id,
			@RequestParam(value="descricao", required=false) String descricao,
			@RequestParam(value="inativo", required=false) String inativo,
			@RequestParam(value="limite", required=true) String limite)
	{
		
		List<Product> list = service.findCustom(id, descricao, inativo, limite);
		return ResponseEntity.ok().body(list);				
	}
}
