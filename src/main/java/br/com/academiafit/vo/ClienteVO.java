package br.com.academiafit.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ClienteVO implements Serializable{
	
	private static final long serialVersionUID =1L;
	
	private long id;
	private String cpf;
	private String nome;
	private Date dtnascimento; 
	private String end;
	private String bairro;
	private String cidade;
	private String estado;
	private String fone;
	private char sexo;
	private Date datacadastro;
	private List<AvaliacaoFisicaVO> listaAvaliacoes;
	private List<TreinoVO> listaTreinos;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDtnascimento() {
		return dtnascimento;
	}
	public void setDtnascimento(Date dtnascimento) {
		this.dtnascimento = dtnascimento;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public Date getDatacadastro() {
		return datacadastro;
	}
	public void setDatacadastro(Date datacadastro) {
		this.datacadastro = datacadastro;
	}
	public List<AvaliacaoFisicaVO> getListaAvaliacoes() {
		return listaAvaliacoes;
	}
	public void setListaAvaliacoes(List<AvaliacaoFisicaVO> listaAvaliacoes) {
		this.listaAvaliacoes = listaAvaliacoes;
	}
	public List<TreinoVO> getListaTreinos() {
		return listaTreinos;
	}
	public void setListaTreinos(List<TreinoVO> listaTreinos) {
		this.listaTreinos = listaTreinos;
	}
}
