package com.conatus.conatussb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.conatus.conatussb.entities.Client;
import com.conatus.conatussb.service.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	@Autowired
	ClientService service;
	
	@GetMapping
	public ResponseEntity<List<Client>> findAll(){
		List<Client> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Client> findById(@PathVariable Long id){
		Client client = service.findById(id);
		return ResponseEntity.ok().body(client);
	}
	
	@GetMapping(value="/custom")
	public ResponseEntity<List<Client>> findByAll(
			@RequestParam(value="id", required=false) Long id,
			@RequestParam(value="nome", required=false) String name,
			@RequestParam(value="cpf", required=false) String cpf,
			@RequestParam(value="rg", required=false) String rg, 
			@RequestParam(value="email", required=false) String email,
			@RequestParam(value="limite", required=false) String limite)
	{
		
		List<Client> list = service.findCustom(id, name, cpf, rg, email,limite);
		return ResponseEntity.ok().body(list);
				
	}
	
	@PostMapping
	public ResponseEntity<Client> insert(@RequestBody Client obj){
		service.insert(obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client obj){
		obj=service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
}
