package com.conatus.conatussb.repositories;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.conatus.conatussb.entities.Client;


@Repository
@Transactional
public class ClientCustomRepository {

	public ClientCustomRepository(EntityManager em) {
		super();
		this.em = em;
	}

	private final EntityManager em;

	public List<Client> find(Long id, String nome, String cpf, String rg, String email, String limite) {
		String query = "SELECT first " + limite + " * FROM CLIENTES ";
		String condicao = "where ";

		if (id != null) {
			query += condicao + "CODIGO LIKE (:id)";
			condicao = "and ";
		}

		if (nome != null) {
			query += condicao + "NOME LIKE (:nome)";
			condicao = "and ";
		}

		if (cpf != null) {
			query += condicao + "CPF LIKE (:cpf)";
			condicao = "and ";
		}

		if (rg != null) {
			query += condicao + "RG LIKE (:rg)";
			condicao = "and ";
		}

		if (email != null) {
			query += condicao + "EMAIL LIKE (:email)";
			condicao = "and ";
		}
		
		query+="ORDER BY CODIGO";

		Query q = em.createNativeQuery(query, Client.class);

		if (id != null) {
			q.setParameter("id", id);
		}

		if (nome != null) {
			q.setParameter("nome", "%" + nome + "%");
		}

		if (cpf != null) {
			q.setParameter("cpf", "%" + cpf + "%");
		}

		if (rg != null) {
			q.setParameter("rg", "%" + rg + "%");
		}

		if (email != null) {
			q.setParameter("email", "%" + email + "%");
		}

		return q.getResultList();
	}

}
