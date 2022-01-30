package com.conatus.conatussb.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="CLIENTES")

public class Client extends People implements Serializable {
	private static final long serialVersionUID = 1L;//Isso possibilita que os dados trafeguem via rede.		
	
	@Column(name = ("NOTIFICA_WHATS"))
	String notificaEmail;
	
	@OneToMany(mappedBy = "client")
	@JsonIgnore
	List<Order> order = new ArrayList<>();
	
	public Client() {
		
	}

	public String getNotificaEmail() {
		return notificaEmail;
	}

	public void setNotificaEmail(String notificaEmail) {
		this.notificaEmail = notificaEmail;
	}

	public List<Order> getOrder() {
		return order;
	}
	
}
