package com.conatus.conatussb.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.conatus.conatussb.entities.Setting;
import com.conatus.conatussb.service.ConfiguracaoService;

@RestController
@RequestMapping(value = "/settings")

public class ConfiguracaoResource {
	
	@Autowired
	ConfiguracaoService service;
	
	@GetMapping()
	public ResponseEntity<Setting> findById(){
		Setting config = service.find();
		return ResponseEntity.ok().body(config);
	}
	
	@PutMapping()
	public ResponseEntity<Setting> update(@RequestBody Setting obj){
		obj=service.update(obj);
		return ResponseEntity.ok().body(obj);
	}
}
