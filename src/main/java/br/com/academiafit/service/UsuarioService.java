package br.com.academiafit.service;

import java.util.List;

import br.com.academiafit.entidade.Usuario;
import br.com.academiafit.exception.BusinessException;
import br.com.academiafit.vo.UsuarioVO;


public interface UsuarioService {
	// Salvar: salva o novo usuário no banco de dados
	public void incluir(UsuarioVO usuarioVO) throws BusinessException;

	// excluir: exclui um usuário do banco
	public void excluir(UsuarioVO usuarioVO) throws BusinessException;

	// alterarSenha: altera a senha de um determinado usuário
	public void alterar(UsuarioVO usuarioVO) throws BusinessException;

	// busca o usuário no banco
	public UsuarioVO consultar(UsuarioVO usuarioVO) throws BusinessException;

	// listarTodos: obtém todos os Usuarios a partir do banco
	public List<UsuarioVO> consultarTodos();
}
