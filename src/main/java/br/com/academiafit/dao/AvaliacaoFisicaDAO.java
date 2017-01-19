package br.com.academiafit.dao;

import java.util.List;
import br.com.academiafit.entidade.AvaliacaoFisica;
import br.com.academiafit.exception.BusinessException;

public interface AvaliacaoFisicaDAO {
	// Salvar: salva o novo Avaliação Física no banco de dados
	public void incluir(AvaliacaoFisica avaliacaoFisica);

	// excluir: exclui um Avaliação Física do banco
	public void excluir(long index);

	// alterarSenha: altera a senha de um determinado Avaliação Física
	public void alterar(AvaliacaoFisica avaliacaoFisica);

	// busca o Avaliação Física no banco
	public boolean consultar(long id);

	// listarTodos: obtém todos os AvaliacaoFisicas a partir do banco
	public List<AvaliacaoFisica> consultarTodos();
}