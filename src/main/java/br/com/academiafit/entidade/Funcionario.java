package br.com.academiafit.entidade;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
@Inheritance(strategy=InheritanceType.JOINED)
public class Funcionario extends Pessoa {

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA")
	private Date datacontrato;
		
	@Column(name = "ESCOLARIDADE")
	private String escolaridade;
	
	@OneToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	public Date getDatacontrato() {
		return datacontrato;
	}

	public void setDatacontrato(Date datacontrato) {
		this.datacontrato = datacontrato;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}	
}
