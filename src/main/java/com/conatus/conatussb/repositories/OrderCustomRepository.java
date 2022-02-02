package com.conatus.conatussb.repositories;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

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

	public Order insert(Order order) {
		try {
			String SQLUPDATE = "INSERT INTO VENDAS (COD_VENDA,DT_VENDA,VL_TOTAL_VENDA,COD_FUNCIONARIO,COD_CLIENTE) VALUES (:codigo,:dt_venda,:vl_total,:cod_func,:cod_cliente)";

			Query q = em.createNativeQuery(SQLUPDATE, Order.class);

			q.setParameter("codigo", order.getCodigo());
			q.setParameter("dt_venda", order.getDataCadastro());
			q.setParameter("vl_total", order.getValorTotal());
			q.setParameter("cod_func", order.getEmployee().getCodigo());
			q.setParameter("cod_cliente", order.getClient().getCodigo());
			q.executeUpdate();
			
			String SQLINSERTPRODUTOSVENDA = "INSERT INTO ITENS_VENDAS (COD_PRODUTOS,COD_VENDA,QT_SERVICO_VENDIDO,VL_UNITARIO_PRODUTO_VENDIDO) VALUES (:COD_PRODUTOS,:COD_VENDA,:QT_SERVICO_VENDIDO,:VL_UNITARIO_PRODUTO_VENDIDO)";
			q = em.createNativeQuery(SQLINSERTPRODUTOSVENDA, Order.class);
			for(OrderItem x : order.getItems()) {
				q.setParameter("COD_PRODUTOS", x.getProduct().getCodigo());
				q.setParameter("COD_VENDA", order.getCodigo());
				q.setParameter("QT_SERVICO_VENDIDO", x.getQuantity());
				q.setParameter("VL_UNITARIO_PRODUTO_VENDIDO", x.getPrice());
				q.executeUpdate();
			}			
			return order;
		} catch (Exception e) {		
			e.printStackTrace();
			return null;
		}
	}
}
