package com.conatus.conatussb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conatus.conatussb.entities.Employee;
import com.conatus.conatussb.repositories.EmployeeCustomRepository;
import com.conatus.conatussb.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository repository;
	
	@Autowired
	EmployeeCustomRepository customRepository;
	
	public List<Employee> findAll(){
		return repository.findAll();
	}
	
	public Employee findById(Long id) {
		Optional<Employee> obj = repository.findById(id);
		return obj.get();
	}

	public List<Employee> findCustom(Long id, String name, String cpf, String rg, String email, String limite){
		return customRepository.find(id, name, cpf, rg, email,limite);
	}
	
	public Employee insert(Employee obj) {
		return repository.save(obj);	
	}
	
	public Employee update(Long id, Employee obj) {
		Employee entity = repository.getOne(id);
		updateData(entity,obj);
		return repository.save(entity);
	}
	
	public void updateData(Employee entity, Employee obj) {
		entity.setBairro(obj.getBairro());
		entity.setCelular(obj.getCelular());
		entity.setCEP(obj.getCEP());
		entity.setComplemento(obj.getComplemento());;
		entity.setCPF(obj.getCPF());
		entity.setData_alteracao(obj.getData_alteracao());
		entity.setEmail(obj.getEmail());
		entity.setEndereco(obj.getEndereco());
		entity.setNome(obj.getNome());
		entity.setNumero(obj.getNumero());
		entity.setObservacao(obj.getObservacao());
		entity.setRG(obj.getRG());
		entity.setTelefone(obj.getTelefone());
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
}
