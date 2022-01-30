package com.conatus.conatussb.entities.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.conatus.conatussb.entities.Order;
import com.conatus.conatussb.entities.Product;

@Embeddable
public class OrderItemPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="COD_VENDA")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name="COD_PRODUTOS")
	private Product produt;
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProdut() {
		return produt;
	}
	public void setProdut(Product produt) {
		this.produt = produt;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((produt == null) ? 0 : produt.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemPK other = (OrderItemPK) obj;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (produt == null) {
			if (other.produt != null)
				return false;
		} else if (!produt.equals(other.produt))
			return false;
		return true;
	}
	
	
	
}
