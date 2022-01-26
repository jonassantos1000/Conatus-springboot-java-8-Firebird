package com.conatus.conatussb.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.conatus.conatussb.entities.Client;

@Repository
public class ClientCustomRepository {
	
	
	public ClientCustomRepository(EntityManager eq) {
		super();
		this.eq = eq;
	}

	private final EntityManager eq;
	
	
	public List<Client> find(Long id, String name, String cpf, String rg, String email, String limite){
		String query = "SELECT first "+limite+" * FROM CLIENTES ";
    	String condicao="where ";
    	
        	
    	if(id!= null) {
    		query+=condicao+"CODIGO = :id";
    		condicao="and ";
    	}
    	
    	if(name!= null) {
    		query+=condicao+"NOME = :name";
    		condicao="and ";
    	}
    	
    	if(cpf!= null) {
    		query+=condicao+"CPF = :cpf";
    		condicao="and ";
    	}
    	
    	if(rg!= null) {
    		query+=condicao+"RG = :rg";
    		condicao="and ";
    	}
    	
    	if(email!= null) {
    		query+=condicao+"EMAIL = :email";
    		condicao="and ";
    	}
    	
    	Query q = eq.createNativeQuery(query, Client.class);
    	
    	if(id!= null) {
    		q.setParameter("id",id);
    	}
    	
    	if(name!= null) {
    		q.setParameter("name", name);
    	}
    	
    	if(cpf!= null) {
    		q.setParameter("cpf", cpf);
    	}
    	
    	if(rg!= null) {
    		q.setParameter("rg", rg);
    	}
    	
    	if(email!= null) {
    		q.setParameter("email", email);
    	}
    	
    	return q.getResultList();
	}
	
	
}
