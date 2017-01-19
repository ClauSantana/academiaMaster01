package br.com.academiafit.dao.impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.academiafit.dao.ClienteDAO;
import br.com.academiafit.entidade.Cliente;
import br.com.academiafit.entidade.Usuario;

@Repository
public class ClienteDAOImpl extends AbstractDAOImpl implements ClienteDAO{

	@Override
	public String incluir(Cliente cliente) {
		this.getEntityManager().persist(cliente);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente inserido com Sucesso!"));
		
		return " ";
	}

	@Override
	public String alterar(Cliente cliente) {
		
		Query query = super.getEntityManager().createQuery("update Cliente af set af.datacadastro = :datacadastro where af.id = :id", Usuario.class);
		query.setParameter("datacadastro", cliente.getDatacadastro());  
		
		query.executeUpdate();

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dados alterados com sucesso"));	

		return null;
	}

	@Override
	public List<Cliente> listarTodos() {
		
		Query query = super.getEntityManager().createQuery("select af from Cliente af");

		List<Cliente> listaCliente = query.getResultList();

		super.getEntityManager().close();
		return listaCliente;
	}

	@Override
	public String excluir(long index) {
		Cliente cliente = super.getEntityManager().find(Cliente.class,index);
		super.getEntityManager().remove(cliente);
		
		return null;
	}

}