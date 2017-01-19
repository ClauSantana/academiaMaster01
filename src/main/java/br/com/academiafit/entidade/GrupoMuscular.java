package br.com.academiafit.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GRUPOMUSCULAR")	
public class GrupoMuscular {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;
	
	@Column(name="MUSCULO")
	private String musculo;
	
	@Column(name="EXERCICIOS")
	private String exercicios;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMusculo() {
		return musculo;
	}

	public void setMusculo(String musculo) {
		this.musculo = musculo;
	}

	public String getExercicios() {
		return exercicios;
	}

	public void setExercicios(String exercicios) {
		this.exercicios = exercicios;
	}
}
