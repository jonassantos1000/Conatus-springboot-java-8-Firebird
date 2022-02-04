package com.conatus.conatussb.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="CONFIGURACOES")
public class Setting implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name="NM_RAZAOSOCIAL")
	private String razaoSocial;
	
	@Column(name="NM_RESPONSAVEL")
    private String responsavelLegal;
	
	@Id
	@Column(name="COD_CONFIGURACAO")
	Long codigo;
	
	@Column(name="NU_CNPJ")
    private String cnpj;
	
	@Column(name="DS_EMAIL")
    private String email;
	
	@Column(name="DS_SENHA_EMAIL")
    private String senha;
	
	@Column(name="DS_SMTP")
    private String smtp;
	
	@Column(name="DS_PORTA_SMTP")
    private String portaSMTP;
	
	@Column(name="DS_SSL")
    private String SSL;
	
	@Column(name="DS_TLS")
    private String TLS;
	
	@Column(name="DS_MENSAGEM_PADRAO")
    private String mensagemPadrao;
    
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT")
	@Column(name="DT_CONFIGURACAO")
	private Instant data;
	
    public Setting() {
    	
    }

	public Setting(String razaoSocial, String responsavelLegal, Long codigo, String cnpj, String email,
			String senha, String smtp, String portaSMTP, String sSL, String tLS, String mensagemPadrao, Instant data) {
		super();
		this.razaoSocial = razaoSocial;
		this.responsavelLegal = responsavelLegal;
		this.codigo = codigo;
		this.cnpj = cnpj;
		this.email = email;
		this.senha = senha;
		this.smtp = smtp;
		this.portaSMTP = portaSMTP;
		SSL = sSL;
		TLS = tLS;
		this.mensagemPadrao = mensagemPadrao;
		this.data = data;
	}



	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getResponsavelLegal() {
		return responsavelLegal;
	}
	public void setResponsavelLegal(String responsavelLegal) {
		this.responsavelLegal = responsavelLegal;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getSmtp() {
		return smtp;
	}
	public void setSmtp(String smtp) {
		this.smtp = smtp;
	}
	public String getPortaSMTP() {
		return portaSMTP;
	}
	public void setPortaSMTP(String portaSMTP) {
		this.portaSMTP = portaSMTP;
	}
	public String getSSL() {
		return SSL;
	}
	public void setSSL(String sSL) {
		SSL = sSL;
	}
	public String getTLS() {
		return TLS;
	}
	public void setTLS(String tLS) {
		TLS = tLS;
	}
	public String getMensagemPadrao() {
		return mensagemPadrao;
	}
	public void setMensagemPadrao(String mensagemPadrao) {
		this.mensagemPadrao = mensagemPadrao;
	}
	
	public Instant getData() {
		return data;
	}

	public void setData(Instant data) {
		this.data = data;
	}
	

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
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
		Setting other = (Setting) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		return true;
	}
    
    
}
