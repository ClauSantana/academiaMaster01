package br.com.academiafit.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
@Inheritance(strategy=InheritanceType.JOINED)
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;
	
	@Column(name="CPF")
	private String cpf;

	@Column( name ="NOME", length=50)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column (columnDefinition = "DATADENASCIMENTO", length=10)
	private Date dtnascimento; 

	@Column (columnDefinition = "ENDERECO", length=50)
	private String end;

	@Column (columnDefinition="BAIRRO", length=50)
	private String bairro;

	@Column (columnDefinition = "CIDADE", length=50)
	private String cidade;

	@Column (columnDefinition= "ESTADO", length=50)
	private String estado;

	@Column (columnDefinition= "TELEFONE", length=50)
	private String fone;

	@Column (columnDefinition= "SEXO", length=1)
	private char sexo;

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
	
}
