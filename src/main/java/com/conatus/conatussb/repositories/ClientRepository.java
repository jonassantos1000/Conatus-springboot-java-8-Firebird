package com.conatus.conatussb.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.conatus.conatussb.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
	
	
}
