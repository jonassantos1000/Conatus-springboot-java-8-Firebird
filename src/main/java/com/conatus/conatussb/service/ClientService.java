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
	
	public Client insert(Client obj) {
		return repository.save(obj);	
	}
	
	public Client update(Long id, Client obj) {
		Client entity = repository.getOne(id);
		updateData(entity,obj);
		return repository.save(entity);
	}
	
	public void updateData(Client entity, Client obj) {
		entity.setBairro(obj.getBairro());
		entity.setCelular(obj.getCelular());
		entity.setCEP(obj.getCEP());
		entity.setComplemento(obj.getComplemento());;
		entity.setCPF(obj.getCPF());
		entity.setData_alteracao(obj.getData_alteracao());
		entity.setEmail(obj.getEmail());
		entity.setEndereco(obj.getEndereco());
		entity.setNome(obj.getNome());
		entity.setNotificaEmail(obj.getNotificaEmail());
		entity.setNumero(obj.getNumero());
		entity.setObservacao(obj.getObservacao());
		entity.setRG(obj.getRG());
		entity.setTelefone(obj.getTelefone());
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
}
