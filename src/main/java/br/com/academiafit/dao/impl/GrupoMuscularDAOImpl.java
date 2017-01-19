package br.com.academiafit.dao.impl;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.academiafit.dao.GrupoMuscularDAO;
import br.com.academiafit.entidade.GrupoMuscular;
import br.com.academiafit.entidade.Usuario;

@Repository
public class GrupoMuscularDAOImpl extends AbstractDAOImpl implements GrupoMuscularDAO{
	
	@Override
	//inseri no banco de dados o comando incluir
	public String incluir (GrupoMuscular grupomuscular){
		super.getEntityManager().persist(grupomuscular);
		
	//retonar uma mensagem para o usuário após a inserção	
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Grupo Muscular inserido com sucesso!"));
		return ""; 
		
	}
	
	@Override
	public String alterar (GrupoMuscular grupomuscular){
		//Criando uma query para inserir no banco de dados os novos dados referente aos campos incluidos pelo o usuário
		Query query = super.getEntityManager().createQuery("upadate GrupoMuscular gm set gm.musculo = :musculo, gm.exercicios = :exercicios");
		
		query.setParameter("musculo", grupomuscular.getMusculo());
	    query.setParameter("exercicios", grupomuscular.getExercicios());
		
	    query.executeUpdate();
	    //retorna uma mensagem para o usuário 
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dados alterados com sucesso!"));
	    return "";
		
	}

	@Override 
	//verificar se a informação solicitada pelo usuário existe no banco de dados
	public String excluir(long index) {
		GrupoMuscular gmuscular = super.getEntityManager().find(GrupoMuscular.class, index);
		//se existir remove a informação desejada	
		super.getEntityManager().remove(gmuscular);
		return "";
	}

	@Override
	public List<GrupoMuscular> consultarTodos() {
		//cria a query que vai inserir a consulta na tabela
		Query query = super.getEntityManager().createQuery("select af from GrupoMuscular gm");
		
		//armazena o resultado da busca na collection criada ResultList
		List<GrupoMuscular> listagMuscular = query.getResultList();
		
		//fecha a conexão
		super.getEntityManager().close();

		return listagMuscular;
	
	} 
}
