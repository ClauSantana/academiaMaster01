package br.com.academiafit.dao;

import java.util.List;
import br.com.academiafit.entidade.Treino;
import br.com.academiafit.exception.BusinessException;

public interface TreinoDAO {		
	// Salvar: salva o novo usuário no banco de dados
	public void incluir(Treino treino);

	// excluir: exclui um usuário do banco
	public void excluir(long index);

	// alterarSenha: altera a senha de um determinado usuário
	public void alterar(Treino treino);

	// busca o usuário no banco
	public boolean consultar(int id);

	// listarTodos: obtém todos os Treinos a partir do banco
	public List<Treino> consultarTodos();
}