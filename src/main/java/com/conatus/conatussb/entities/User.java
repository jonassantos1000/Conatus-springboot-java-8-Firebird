package com.conatus.conatussb.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "USUARIOS")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COD_USUARIO")
	private long codigo;
	
	@Column(name="USUARIO")
	private String usuario;
	
	@Column(name="SENHA")
	private String senha;
	
	@Column(name="GERENCIA")
	private String gerencia;

	public User() {

	}

	public User(long codigo, String usuario, String senha, String gerencia) {
		super();
		this.codigo = codigo;
		this.usuario = usuario;
		this.senha = senha;
		this.gerencia = gerencia;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getGerencia() {
		return gerencia;
	}

	public void setGerencia(String gerencia) {
		this.gerencia = gerencia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codigo ^ (codigo >>> 32));
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		User other = (User) obj;
		if (codigo != other.codigo)
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

}
