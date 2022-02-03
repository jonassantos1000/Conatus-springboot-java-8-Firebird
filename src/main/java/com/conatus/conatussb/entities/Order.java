package com.conatus.conatussb.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="VENDAS")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="COD_VENDA")
	private Long codigo;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT")
	@Column(name="DT_VENDA")
    private Instant dataCadastro;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT")
	@Column(name="DT_ALTERACAO")
    private Instant dataAlteracao;
    
    @ManyToOne
    @JoinColumn(name="COD_CLIENTE")
    private Client client;
    
    @ManyToOne
    @JoinColumn(name="COD_FUNCIONARIO")
    private Employee employee;
    
	@OneToMany(mappedBy = "id.order", cascade = CascadeType.ALL)
	private Set<OrderItem> items = new HashSet<>();
	
	
	@Column(name="VL_TOTAL_VENDA")
	private Double valorTotal;

	public Order() {
    	
    }
 
	public Order(Long codigo, Instant dataCadastro, Instant dataAlteracao, Double valorTotal) {
		super();
		this.codigo = codigo;
		this.dataCadastro = dataCadastro;
		this.dataAlteracao = dataAlteracao;
		this.valorTotal = valorTotal;
	}

	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public Instant getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Instant dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public Instant getDataAlteracao() {
		return dataAlteracao;
	}
	public void setDataAlteracao(Instant dataAlteracao) {
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
	
	public Set<OrderItem> getItems() {
		return items;
	}
		
	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
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
