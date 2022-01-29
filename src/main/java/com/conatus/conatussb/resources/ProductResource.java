package com.conatus.conatussb.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<Product> insert(@RequestBody Product obj){
		service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCodigo()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product obj){
		obj=service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
