package com.conatus.conatussb.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.conatus.conatussb.entities.Order;
import com.conatus.conatussb.entities.OrderItem;

@Repository
@Transactional
public class OrderCustomRepository {
	
	public OrderCustomRepository(EntityManager em) {
		super();
		this.em = em;
	}

	private final EntityManager em;
	
	
	
	@Autowired
	OrderRepository repo;
	
	public Order insert(Order order) {
		for(OrderItem x : order.getItems()) {
			x.setOrder(order);
		}
		return repo.save(order);
	}	
	
	public List<Order> findCustom(Long codOrder,Long codClient,String nameClient,String cpfClient,String rgClient,String nameEmployee,String data,String limite){
		try {
            if (limite==null || limite.equals("0") || limite.isEmpty()) {
                limite = "99999999";
            }

            String query = "SELECT FIRST " + limite + " * FROM VWMOVIMENTACAO m ";
			String condicao = "where ";
			
            //codigo_venda
            if (codOrder != null) {
    			query += condicao + "m.COD_VENDA LIKE (:codOrder)";
    			condicao = "and ";
    		}
            
            //codigo_cliente
            if (codClient != null) {
    			query += condicao + "m.COD_CLIENTE LIKE (:codClient)";
    			condicao = "and ";
    		}
            
            //Nome_cliente
            if (nameClient != null) {
    			query += condicao + "m.NOMECLIENTE LIKE (:nameClient)";
    			condicao = "and ";
    		}
            
            //cpf_cliente
            if (cpfClient != null) {
    			query += condicao + "m.CPFCLIENTE LIKE (:cpfClient)";
    			condicao = "and ";
    		}
            
            //rg_cliente
            if (rgClient != null) {
    			query += condicao + "m.RGCLIENTE LIKE (:rgClient)";
    			condicao = "and ";
    		}

            //rg_cliente
            if (nameEmployee != null) {
    			query += condicao + "m.NOMEFUNCIONARIO LIKE (:nameEmployee)";
    			condicao = "and ";
    		}         

            if (data!=null && !"".equals(data) && !";".equals(data)) {
            	try {
	                String desmembraData[] = data.split(";");
	                String dataInicial = desmembraData[0];
	                String dataFinal = desmembraData[1];
	                
	                query += condicao + "CAST(m.DT_VENDA AS date) BETWEEN '" + dataInicial + "' AND '" + dataFinal + "'";
	    			condicao = "and ";
            	}catch(Exception e){
	    				e.printStackTrace();
	    			}
            }
            
            query = query + " ORDER BY m.COD_VENDA";
            
            Query q = em.createNativeQuery(query, Order.class);
            		
            //codigo_venda
            if (codOrder != null) {
            	q.setParameter("codOrder", codOrder);
    		}
            
            //codigo_cliente
            if (codClient != null) {
            	q.setParameter("codClient", codClient);
    		}
            
            //Nome_cliente
            if (nameClient != null) {
            	q.setParameter("nameClient", "%"+nameClient+"%");
    		}
            
            //cpf_cliente
            if (cpfClient != null) {
            	q.setParameter("cpfClient", cpfClient);
    		}
            
            //rg_cliente
            if (rgClient != null) {
            	q.setParameter("rgClient", rgClient);
    		}

            //rg_cliente
            if (nameEmployee != null) {
            	q.setParameter("nameEmployee", "%"+nameEmployee+"%");
    		}         
            
            return q.getResultList();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
