package br.com.academiafit.vo;

import java.util.Date;

public class AvaliacaoFisicaVO {
	
	private long id;
	private Date dataavaliacao;
	private double altura;
	private double peso;
	private double imc;
	private double peito;
	private double cintura;
	private double quadril;
	private double bracoDireito;
	private double bracoEsquerdo;
	private double coxaDireito;
	private double coxaEsquerdo;
	private double panturrilhaDireito;
	private double panturrilhaEsquerdo;
	
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
		this.imc = this.peso/(this.altura*this.altura);
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
	
	
}
