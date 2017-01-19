package br.com.academiafit.entidade;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="CLIENTE")
public class Cliente extends Pessoa{
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATACADASTRO")
	private Date datacadastro;
	
	@OneToMany
	private List<AvaliacaoFisica> listaAvaliacaoFisica;
	
	@OneToMany
	private List<Treino> listaTreino;

	public Date getDatacadastro() {
		return datacadastro;
	}

	public void setDatacadastro(Date datacadastro) {
		this.datacadastro = datacadastro;
	}

	public List<AvaliacaoFisica> getListaAvaliacaoFisica() {
		return listaAvaliacaoFisica;
	}

	public void setListaAvaliacaoFisica(List<AvaliacaoFisica> listaAvaliacaoFisica) {
		this.listaAvaliacaoFisica = listaAvaliacaoFisica;
	}

	public List<Treino> getListaTreino() {
		return listaTreino;
	}

	public void setListaTreino(List<Treino> listaTreino) {
		this.listaTreino = listaTreino;
	}
	
}
