package com.conatus.conatussb.repositories;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.conatus.conatussb.entities.User;


@Repository
@Transactional
public class UserCustomRepository {

	public UserCustomRepository(EntityManager em) {
		super();
		this.em = em;
	}

	private final EntityManager em;

	public List<User> findByName(String nome) {
		String query = "SELECT * FROM USUARIOS WHERE USUARIO = :usuario";
		
		Query q = em.createNativeQuery(query, User.class);
		q.setParameter("usuario", nome);

		return q.getResultList();
	}

}
