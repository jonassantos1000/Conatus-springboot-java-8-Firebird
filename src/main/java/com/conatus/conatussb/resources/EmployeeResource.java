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

import com.conatus.conatussb.entities.Employee;
import com.conatus.conatussb.service.EmployeeService;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeResource {
	
	@Autowired
	EmployeeService service;
	
	@GetMapping
	public ResponseEntity<List<Employee>> findAll(){
		List<Employee> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Employee> findById(@PathVariable Long id){
		Employee employee = service.findById(id);
		return ResponseEntity.ok().body(employee);
	}
	
	@GetMapping(value="/custom")
	public ResponseEntity<List<Employee>> findByAll(
			@RequestParam(value="id", required=false) Long id,
			@RequestParam(value="nome", required=false) String name,
			@RequestParam(value="cpf", required=false) String cpf,
			@RequestParam(value="rg", required=false) String rg, 
			@RequestParam(value="email", required=false) String email,
			@RequestParam(value="limite", required=true) String limite)
	{
		
		List<Employee> list = service.findCustom(id, name, cpf, rg, email,limite);
		return ResponseEntity.ok().body(list);
				
	}
	
	@PostMapping
	public ResponseEntity<Employee> insert(@RequestBody Employee obj){
		service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCodigo()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody Employee obj){
		obj=service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
