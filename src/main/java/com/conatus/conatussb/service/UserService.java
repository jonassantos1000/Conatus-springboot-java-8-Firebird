package com.conatus.conatussb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conatus.conatussb.entities.User;
import com.conatus.conatussb.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	public User insert(User obj) {
		return repository.save(obj);	
	}
	
	public User update(Long id, User obj) {
		User entity = repository.getOne(id);
		updateData(entity,obj);
		return repository.save(entity);
	}
	
	public void updateData(User entity, User obj) {
		entity.setGerencia(obj.getGerencia());
		entity.setSenha(obj.getSenha());
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
}
