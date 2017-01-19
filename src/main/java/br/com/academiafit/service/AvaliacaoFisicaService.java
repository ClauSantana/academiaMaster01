package br.com.academiafit.service;

import java.util.List;

import br.com.academiafit.exception.BusinessException;
import br.com.academiafit.vo.AvaliacaoFisicaVO;

public interface AvaliacaoFisicaService {
	// Salvar: salva o novo avaliacaoFisica no banco de dados
	public void incluir(AvaliacaoFisicaVO avaliacaoFisicaVO) throws BusinessException;

	// excluir: exclui um avaliacaoFisica do banco
	public void excluir(AvaliacaoFisicaVO avaliacaoFisicaVO) throws BusinessException;

	// alterarSenha: altera a senha de um determinado avaliacaoFisica
	public void alterar(AvaliacaoFisicaVO avaliacaoFisicaVO) throws BusinessException;

	// busca o avaliacaoFisica no banco
	public AvaliacaoFisicaVO consultar(AvaliacaoFisicaVO avaliacaoFisicaVO) throws BusinessException;

	// listarTodos: obtém todos os AvaliacaoFisicas a partir do banco
	public List<AvaliacaoFisicaVO> consultarTodos();
}