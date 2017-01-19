package br.com.academiafit.dao.impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.academiafit.dao.FuncionarioDAO;
import br.com.academiafit.entidade.Funcionario;
import br.com.academiafit.entidade.Usuario;

@Repository
public class FuncionarioDAOImpl extends AbstractDAOImpl implements FuncionarioDAO{

	@Override
	public String incluir(Funcionario funcionario) {
		this.getEntityManager().persist(funcionario);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Funcionario inserido com Sucesso!"));
		
		return " ";
	}

	@Override
	public String alterar(Funcionario funcionario) {
		Query query = super.getEntityManager().createQuery("update Funcionario af set af.datacontrato = :datacontrato, af.escolaridade = :escolaridade where af.id = :id", Usuario.class);

		query.setParameter("datacontrato", funcionario.getDatacontrato());
		query.setParameter("escolaridade", funcionario.getEscolaridade());
		
		query.executeUpdate();

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dados alterados com sucesso"));	
		
		return null;
	}

	@Override
	public String excluir(long index) {
		Funcionario funcionario = super.getEntityManager().find(Funcionario.class,index);

		super.getEntityManager().remove(funcionario);
		
		return null;
	}

	@Override
	public List<Funcionario> listarTodos() {
		Query query = super.getEntityManager().createQuery("select af from Funcionario af");

		List<Funcionario> listaFuncionario = query.getResultList();

		super.getEntityManager().close();
		
		return listaFuncionario;
		
		
	}
	
}
