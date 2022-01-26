package com.conatus.conatussb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conatus.conatussb.entities.Client;
import com.conatus.conatussb.repositories.ClientCustomRepository;
import com.conatus.conatussb.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	ClientRepository repository;
	
	@Autowired
	ClientCustomRepository customRepository;
	
	public List<Client> findAll(){
		return repository.findAll();
	}
	
	public Client findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		return obj.get();
	}

	public List<Client> findCustom(Long id, String name, String cpf, String rg, String email, String limite){
		return customRepository.find(id, name, cpf, rg, email,limite);
	}
	
}
