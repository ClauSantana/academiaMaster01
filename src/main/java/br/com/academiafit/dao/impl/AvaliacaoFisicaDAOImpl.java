package br.com.academiafit.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.academiafit.dao.AvaliacaoFisicaDAO;
import br.com.academiafit.entidade.AvaliacaoFisica;
import br.com.academiafit.entidade.Treino;

@Repository
public class AvaliacaoFisicaDAOImpl extends AbstractDAOImpl implements AvaliacaoFisicaDAO{

	// Salvar: salva o novo avaliacaoFisica no banco de dados
	@Override	
	public void incluir(AvaliacaoFisica avaliacaoFisica){
		// incluir o avaliacaoFisica correspondente
		super.getEntityManager().persist(avaliacaoFisica);
	}

	// excluir: exclui um avaliacaoFisica do banco
	@Override
	public void excluir(long index){
		// exclui o avaliacaoFisica correspondente
		AvaliacaoFisica user = super.getEntityManager().find(AvaliacaoFisica.class, index);	
		super.getEntityManager().remove(index);

	}

	// alterarSenha: altera a senha de um determinado avaliacaoFisica
	@Override
	public void alterar(AvaliacaoFisica avaliacaoFisica){
		// merge = atualizar
		this.getEntityManager().merge(avaliacaoFisica);
	}

	// busca o avaliacaoFisica no banco
	@Override
	public boolean consultar(long id){
		// encontra o avaliacaoFisica no banco de dados
		// se o avaliacaoFisica existir, retorna true, se não, retorna false.
		return (super.getEntityManager().find(AvaliacaoFisica.class, id) != null);

	}

	// listarTodos: obtém todas as avaliações físicas a partir do banco
	@Override
	public List<AvaliacaoFisica> consultarTodos(){
		// cria uma query com o select na tabela
		Query query = super.getEntityManager().createQuery("select a from AvaliacaoFisica a");

		// armazena o resultado da busca numa collection de avaliações físicas
		List<AvaliacaoFisica> listaAvaliacoes = query.getResultList();

		return listaAvaliacoes;
	}
}