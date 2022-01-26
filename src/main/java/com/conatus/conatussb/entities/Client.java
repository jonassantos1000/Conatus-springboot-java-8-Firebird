package com.conatus.conatussb.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="CLIENTES")

public class Client extends Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;//Isso possibilita que os dados trafeguem via rede.
		
	public Client() {
		
	}
			
}
