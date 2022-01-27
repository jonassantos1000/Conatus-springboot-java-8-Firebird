package com.conatus.conatussb.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.conatus.conatussb.entities.Counters;

@Repository
@Transactional
public class CountersCustomRepository {

	public CountersCustomRepository(EntityManager em) {
		super();
		this.em = em;
	}

	private final EntityManager em;
	private String campo;
	int valor;

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public List<Counters> consultaCodigo(String campo) {
		try {
			setCampo(campo);
			String SQLSELECTCODIGO = "SELECT * FROM COUNTERS WHERE NOME= :nome";
			Query q = em.createNativeQuery(SQLSELECTCODIGO, Counters.class);

			if (campo != null) {
				q.setParameter("nome", campo);
				List<Counters> value = q.getResultList();

				for (Counters x : value) {
					setValor(x.getValor());
				}
				alteraCodigo(getValor());
			}
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
	public void alteraCodigo(int valor) {
		try {
			String SQLALTERARCOUNTERS = "UPDATE COUNTERS SET VALOR= :valor WHERE NOME= :nome";
			int countersnovo;
			countersnovo = getValor() + 1;

			Query q = em.createNativeQuery(SQLALTERARCOUNTERS, Counters.class);

			if (getCampo() != null) {
				q.setParameter("valor", countersnovo);
				q.setParameter("nome", getCampo());
				q.executeUpdate();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
