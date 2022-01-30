package com.conatus.conatussb.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="FUNCIONARIO")

public class Employee extends People implements Serializable {
	private static final long serialVersionUID = 1L;//Isso possibilita que os dados trafeguem via rede.
		
	public Employee() {
		
	}
		
	@JsonIgnore
	@OneToMany(mappedBy = "employee")
	List<Order> order = new ArrayList<>();

	public List<Order> getOrder() {
		return order;
	}
	
	
}
