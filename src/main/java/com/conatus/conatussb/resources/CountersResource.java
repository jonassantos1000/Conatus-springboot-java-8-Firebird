package com.conatus.conatussb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.conatus.conatussb.entities.Counters;
import com.conatus.conatussb.service.CountersService;

@RestController
@RequestMapping(value = "/counters")
public class CountersResource {
	
	@Autowired
	CountersService countersService;

	@GetMapping(value="/{campo}")
	public ResponseEntity<List<Counters>> consultaCodigo(@PathVariable String campo) {
		List<Counters> c = countersService.consultaCodigo(campo);	
		return ResponseEntity.ok().body(c);
	}
}
