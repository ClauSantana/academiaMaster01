package br.com.academiafit.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="treino")
public class Treino {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="diasemana")
	private String diasemana;
	
	@Column(name="series")
	private int series;
	
	@Column(name="repeticoes")
	private int repeticoes;
	
	@OneToOne
	@JoinColumn(name="id_maquinario")
	private Maquinario maquinario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDiasemana() {
		return diasemana;
	}

	public void setDiasemana(String diasemana) {
		this.diasemana = diasemana;
	}

	public int getSeries() {
		return series;
	}

	public void setSeries(int series) {
		this.series = series;
	}

	public int getRepeticoes() {
		return repeticoes;
	}

	public void setRepeticoes(int repeticoes) {
		this.repeticoes = repeticoes;
	}

	public Maquinario getMaquinario() {
		return maquinario;
	}

	public void setMaquinario(Maquinario maquinario) {
		this.maquinario = maquinario;
	}	
	
}
