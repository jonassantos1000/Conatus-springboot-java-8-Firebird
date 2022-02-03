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

import com.conatus.conatussb.entities.Order;
import com.conatus.conatussb.service.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	
	@Autowired
	OrderService service;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order client = service.findById(id);
		return ResponseEntity.ok().body(client);
	}
	
	@GetMapping(value="/custom")
	public ResponseEntity<List<Order>> findById
	(
			@RequestParam(value="codOrder", required=false) Long codOrder,
			@RequestParam(value="codClient", required=false) Long codClient,
			@RequestParam(value="nameClient", required=false) String nameClient,
			@RequestParam(value="cpfClient", required=false) String cpfClient, 
			@RequestParam(value="rgClient", required=false) String rgClient,
			@RequestParam(value="nameEmployee", required=false) String nameEmployee,
			@RequestParam(value="data", required=false) String data,
			@RequestParam(value="limite", required=false)String limite
	)
	
	{
		List<Order> order = service.findAllCustom(codOrder, codClient, nameClient, cpfClient, rgClient, nameEmployee, data, limite);
		return ResponseEntity.ok().body(order);
	}
		
	@PostMapping
	public ResponseEntity<Order> insert(@RequestBody Order obj){
		service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCodigo()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Order> update(@PathVariable Long id, @RequestBody Order obj){
		obj=service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
