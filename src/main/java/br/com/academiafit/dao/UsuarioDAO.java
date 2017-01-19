package br.com.academiafit.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.academiafit.entidade.Usuario;
import br.com.academiafit.exception.BusinessException;

public interface UsuarioDAO {
	// Salvar: salva o novo usuário no banco de dados
	public void incluir(Usuario usuario);

	// excluir: exclui um usuário do banco
	public void excluir(String nickname);

	// alterarSenha: altera a senha de um determinado usuário
	public void alterar(Usuario usuario);
	
	// busca o usuário no banco
	public boolean consultar(String nickname);
	
	// listarTodos: obtém todos os Usuarios a partir do banco
	public List<Usuario> consultarTodos();
}