package br.com.academiafit.entidade;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MAQUINARIO")
public class Maquinario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;
	
	@Column(name="NOME")
	private String nome;
	
	@OneToMany
	private List<GrupoMuscular> listaGrupoMuscular;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<GrupoMuscular> getListaGrupoMuscular() {
		return listaGrupoMuscular;
	}

	public void setListaGrupoMuscular(List<GrupoMuscular> listaGrupoMuscular) {
		this.listaGrupoMuscular = listaGrupoMuscular;
	}
	
}
