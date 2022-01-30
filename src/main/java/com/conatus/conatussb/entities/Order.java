package com.conatus.conatussb.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="VENDAS")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="COD_VENDA")
	private Long codigo ;
	
	@Column(name="DT_VENDA")
    private String dataCadastro;
	
	@Column(name="DT_ALTERACAO")
    private String dataAlteracao;
    
    @ManyToOne
    @JoinColumn(name="COD_CLIENTE")
    private Client client;
    
    @ManyToOne
    @JoinColumn(name="COD_FUNCIONARIO")
    private Employee employee;

	public Order() {
    	
    }
    
	public Order(Long codigo, String dataCadastro, String dataAlteracao) {
		super();
		this.codigo = codigo;
		this.dataCadastro = dataCadastro;
		this.dataAlteracao = dataAlteracao;
	}
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public String getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getDataAlteracao() {
		return dataAlteracao;
	}
	public void setDataAlteracao(String dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
    public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Order other = (Order) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
    
	
    
    
    
}
