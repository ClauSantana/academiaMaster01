package br.com.academiafit.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.academiafit.exception.BusinessException;
import br.com.academiafit.util.Util;


@Entity
@Table(name="avaliacaofisica")
public class AvaliacaoFisica{	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="dataavaliacao")
	@Temporal(TemporalType.DATE)
	private Date dataavaliacao;
	
	@Column(name="altura")
	private double altura;
	
	@Column(name="peso")
	private double peso;
	
	@Column(name="imc")
	private double imc;
	
	@Column(name="peito")
	private double peito;
	
	@Column(name="cintura")
	private double cintura;
	
	@Column(name="quadril")
	private double quadril;
	
	@Column(name="bracodireito")
	private double bracoDireito;
	
	@Column(name="bracoesquerdo")
	private double bracoEsquerdo;
	
	@Column(name="coxadireito")
	private double coxaDireito;
	
	@Column(name="coxaesquerdo")
	private double coxaEsquerdo;
	
	@Column(name="panturrilhadireito")
	private double panturrilhaDireito;
	
	@Column(name="panturrilhaesquerdo")
	private double panturrilhaEsquerdo;
	
	@OneToOne
	@JoinColumn(name="id_professor")
	private Professor professor;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDataavaliacao() {
		return dataavaliacao;
	}

	public void setDataavaliacao(Date dataavaliacao) {
		this.dataavaliacao = dataavaliacao;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getImc() {
		return imc;
	}

	public void setImc() {
		try{
			Util.calcularIMC(this.altura, this.peso);
		}catch(BusinessException exception){
			this.imc = 0;
		}
	}

	public double getPeito() {
		return peito;
	}

	public void setPeito(double peito) {
		this.peito = peito;
	}

	public double getCintura() {
		return cintura;
	}

	public void setCintura(double cintura) {
		this.cintura = cintura;
	}

	public double getQuadril() {
		return quadril;
	}

	public void setQuadril(double quadril) {
		this.quadril = quadril;
	}

	public double getBracoDireito() {
		return bracoDireito;
	}

	public void setBracoDireito(double bracoDireito) {
		this.bracoDireito = bracoDireito;
	}

	public double getBracoEsquerdo() {
		return bracoEsquerdo;
	}

	public void setBracoEsquerdo(double bracoEsquerdo) {
		this.bracoEsquerdo = bracoEsquerdo;
	}

	public double getCoxaDireito() {
		return coxaDireito;
	}

	public void setCoxaDireito(double coxaDireito) {
		this.coxaDireito = coxaDireito;
	}

	public double getCoxaEsquerdo() {
		return coxaEsquerdo;
	}

	public void setCoxaEsquerdo(double coxaEsquerdo) {
		this.coxaEsquerdo = coxaEsquerdo;
	}

	public double getPanturrilhaDireito() {
		return panturrilhaDireito;
	}

	public void setPanturrilhaDireito(double panturrilhaDireito) {
		this.panturrilhaDireito = panturrilhaDireito;
	}

	public double getPanturrilhaEsquerdo() {
		return panturrilhaEsquerdo;
	}

	public void setPanturrilhaEsquerdo(double panturrilhaEsquerdo) {
		this.panturrilhaEsquerdo = panturrilhaEsquerdo;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	
}