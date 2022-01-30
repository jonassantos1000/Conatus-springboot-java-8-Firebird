package com.conatus.conatussb.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonFormat;

@MappedSuperclass
public abstract class People implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = ("CODIGO"))
	Long codigo;

	@Column(name = ("NOME"))
	String nome;

	@Column(name = ("CPF"))
	String cpf;

	@Column(name = ("CELULAR"))
	String celular;

	@Column(name = ("EMAIL"))
	String email;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT")
	@Column(name = ("DATA_CADASTRO"))
	Instant data_cadastro;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT")
	@Column(name = ("DATA_ALTERACAO"))
	Instant data_alteracao;

	@Column(name = ("RG"))
	String rg;

	@Column(name = ("ENDERECO"))
	String endereco;

	@Column(name = ("BAIRRO"))
	String bairro;

	@Column(name = ("NUMERO"))
	String numero;

	@Column(name = ("CEP"))
	String cep;

	@Column(name = ("COMPLEMENTO"))
	String complemento;

	@Column(name = ("TELEFONE"))
	String telefone;

	@Column(name = ("OBSERVACAO"))
	String observacao;

	public People() {

	}

	public People(Long codigo, String nome, String cpf, String RG, String celular, String email, Instant data,
			String endereco, String bairro, String numero, String complemento, String telefone, String observacao, String CEP, Instant data_alteracao) {
		setCodigo(codigo);
		setNome(nome);
		setCPF(cpf);
		setRG(RG);
		setCelular(celular);
		setEmail(email);
		setData_cadastro(data);
		setEndereco(endereco);
		setBairro(bairro);
		setNumero(numero);
		setComplemento(complemento);
		setTelefone(telefone);
		setObservacao(observacao);
		setCEP(CEP);
		setData_alteracao(data_alteracao);
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public void setRG(String rg) {
		this.rg = rg;
	}

	public String getRG() {
		return rg;
	}

	public Instant getData_alteracao() {
		return data_alteracao;

	}

	public void setData_alteracao(Instant data_alteracao) {
		this.data_alteracao = data_alteracao;

	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCEP() {
		return cep;
	}

	public void setCEP(String CEP) {
		this.cep = CEP;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Instant getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(Instant data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return cpf;
	}

	public void setCPF(String cpf) {
		this.cpf = cpf;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
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
		People other = (People) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		return true;
	}
}
