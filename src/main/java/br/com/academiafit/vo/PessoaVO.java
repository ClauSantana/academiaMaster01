package br.com.academiafit.vo;

import java.util.Date;

public class PessoaVO {

	private int cpf;
	private Date datanascimento;
	private char enderenco;
	private char bairro;
	private char cidade;
	private char estado;
	private char telefone;
	private char sexo;
	private boolean ativo;
	
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public Date getDatanascimento() {
		return datanascimento;
	}
	public void setDatanascimento(Date datanascimento) {
		this.datanascimento = datanascimento;
	}
	public char getEnderenco() {
		return enderenco;
	}
	public void setEnderenco(char enderenco) {
		this.enderenco = enderenco;
	}
	public char getBairro() {
		return bairro;
	}
	public void setBairro(char bairro) {
		this.bairro = bairro;
	}
	public char getCidade() {
		return cidade;
	}
	public void setCidade(char cidade) {
		this.cidade = cidade;
	}
	public char getEstado() {
		return estado;
	}
	public void setEstado(char estado) {
		this.estado = estado;
	}
	public char getTelefone() {
		return telefone;
	}
	public void setTelefone(char telefone) {
		this.telefone = telefone;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	
}
