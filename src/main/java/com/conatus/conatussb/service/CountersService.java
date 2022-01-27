package com.conatus.conatussb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conatus.conatussb.entities.Counters;
import com.conatus.conatussb.repositories.CountersCustomRepository;

@Service
public class CountersService {
	
	@Autowired
	CountersCustomRepository repository;
	
	public List<Counters> consultaCodigo(String campo) {
		return repository.consultaCodigo(campo);
	}
}
