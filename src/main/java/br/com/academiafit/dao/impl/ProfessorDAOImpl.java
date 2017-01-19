package br.com.academiafit.dao.impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.academiafit.dao.ProfessorDAO;
import br.com.academiafit.entidade.Cliente;
import br.com.academiafit.entidade.Pessoa;
import br.com.academiafit.entidade.Professor;
import br.com.academiafit.entidade.Usuario;

@Repository
public class ProfessorDAOImpl extends AbstractDAOImpl implements ProfessorDAO{

	@Override
	public String incluir(Professor professor) {
        this.getEntityManager().persist(professor);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Professor inserido com Sucesso!"));
		
		return " ";
	}

	@Override
	public String alterar(Professor professor) {
		Query query = super.getEntityManager().createQuery("update Professor af set af.horario = :horario where af.id = :id", Usuario.class);

		query.setParameter("horario", professor.getHorario());
		query.executeUpdate();

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dados alterados com sucesso"));	

		return null;
	}

	@Override
	public String excluir(long index) {
		Professor user = super.getEntityManager().find(Professor.class, index);
		Professor professor = super.getEntityManager().find(Professor.class,index);

		super.getEntityManager().remove(professor);
		return null;
	}

	@Override
	public List<Professor> listarTodos() {
		
		Query query = super.getEntityManager().createQuery("select af from Professor af");

		List<Professor> listaProfessor = query.getResultList();

		super.getEntityManager().close();
		return listaProfessor;
	}
}
