package br.com.academiafit.dao.impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.academiafit.dao.MaquinarioDAO;
import br.com.academiafit.entidade.Maquinario;
import br.com.academiafit.entidade.Usuario;

@Repository
public class MaquinarioDAOImpl extends AbstractDAOImpl implements MaquinarioDAO {
	
	@Override
	public String incluir (Maquinario maquinario){
		super.getEntityManager().persist(maquinario);
	
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Máquina inserida com sucesso!"));
		return ""; 

}
	
	@Override
	public String alterar (Maquinario maquinario){
		Query query = super.getEntityManager().createQuery("update Maquinario ma set ma.nome = :nome");
		
		query.setParameter("nome", maquinario.getNome());
		query.executeUpdate();
		
		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dados alterados com sucesso!"));
	     return "";
}
	
	@Override
	public String excluir(long index) {
		Maquinario mamaquinario = super.getEntityManager().find(Maquinario.class, index);
		
		super.getEntityManager().remove(mamaquinario);
		return "";
		
	}
	
	@Override
	public List<Maquinario> consultarTodos() {
		Query query = super.getEntityManager().createQuery("select af from Maquinario ma");
		
		List<Maquinario> listamaMaquinario = query.getResultList();
		
		super.getEntityManager().close();
		return listamaMaquinario;
	}
}
