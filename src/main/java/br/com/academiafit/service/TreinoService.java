package br.com.academiafit.service;

import java.util.List;

import br.com.academiafit.exception.BusinessException;
import br.com.academiafit.vo.TreinoVO;

public interface TreinoService {
	// Salvar: salva o novo treino no banco de dados
		public void incluir(TreinoVO treinoVO) throws BusinessException;

		// excluir: exclui um treino do banco
		public void excluir(TreinoVO treinoVO) throws BusinessException;

		// alterarSenha: altera a senha de um determinado treino
		public void alterar(TreinoVO treinoVO) throws BusinessException;

		// busca o treino no banco
		public TreinoVO consultar(TreinoVO treinoVO) throws BusinessException;

		// listarTodos: obtém todos os Treinos a partir do banco
		public List<TreinoVO> consultarTodos();
}