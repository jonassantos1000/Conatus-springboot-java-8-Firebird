package com.conatus.conatussb.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.conatus.conatussb.entities.Product;


@Repository
public class ProductCustomRepository {
	
	private final EntityManager em;

	public ProductCustomRepository(EntityManager em) {
		super();
		this.em = em;
	}
	
	public List<Product> findCustomAll(Long id, String descricao, String inativo, String limite) {
		
		String query = "SELECT FIRST " + limite + " * FROM PRODUTOS as s ";
		
		String condicao = "where ";

		if (id != null) {
			query += condicao + "COD_PRODUTOS LIKE (:id)";
			condicao = " and ";
		}

		if (descricao != null) {
			query += condicao + "DESCRICAO LIKE (:descricao)";
			condicao = " and ";
		}

		if(inativo != null) {
			if (inativo.equals("F")) {
				query += condicao + "INATIVO = (:inativo)";
				condicao = " and ";
			}
		}
		
		query+="ORDER BY COD_PRODUTOS";

		Query q = em.createNativeQuery(query, Product.class);

		if (id != null) {
			q.setParameter("id","%" + id + "%");
		}

		if (descricao != null) {
			q.setParameter("descricao", "%" + descricao + "%");
		}
		
		if(inativo != null) {
			if (inativo.equals("F") ) {
				q.setParameter("inativo", inativo);
			}
		}

		return q.getResultList();
	}
	
}
