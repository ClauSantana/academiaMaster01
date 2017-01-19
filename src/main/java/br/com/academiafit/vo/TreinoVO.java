package br.com.academiafit.vo;

public class TreinoVO {
	private String diasemana;
	private int id;
	private int series;
	private int repeticoes;
	
	public int getId(){
		return id;
	}
	public void setId(int id){
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
}
