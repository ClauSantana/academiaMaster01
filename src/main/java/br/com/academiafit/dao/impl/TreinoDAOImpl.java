package br.com.academiafit.dao.impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.academiafit.dao.TreinoDAO;
import br.com.academiafit.entidade.Treino;
import br.com.academiafit.entidade.Usuario;
import br.com.academiafit.entidade.Treino;
import br.com.academiafit.exception.BusinessException;

@Repository
public class TreinoDAOImpl extends AbstractDAOImpl implements TreinoDAO{
	// Salvar: salva o novo treino no banco de dados
	@Override	
	public void incluir(Treino treino){
		// incluir o treino correspondente
		super.getEntityManager().persist(treino);
	}

	// excluir: exclui um treino do banco
	@Override
	public void excluir(long index){
		// exclui o treino correspondente
		Treino treino = super.getEntityManager().find(Treino.class, index);
		super.getEntityManager().remove(treino);

		// fecha a conexão
		super.getEntityManager().close();
	}

	// alterarSenha: altera a senha de um determinado treino
	@Override
	public void alterar(Treino treino){
		// merge = atualizar
		this.getEntityManager().merge(treino);
	}

	// busca o treino no banco
	@Override
	public boolean consultar(int id){
		// encontra o treino no banco de dados
		// se o treino existir, retorna true, se não, retorna false.
		return (super.getEntityManager().find(Treino.class, id) != null);

	}

	// listarTodos: obtém todos os Treinos a partir do banco
	@Override
	public List<Treino> consultarTodos(){
		// cria uma query com o select na tabela treino
		Query query = super.getEntityManager().createQuery("select t from Treino t");

		// armazena o resultado da busca numa collection de treinos
		List<Treino> listaTreino = query.getResultList();
		return listaTreino;
	}
}
