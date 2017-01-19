package br.com.academiafit.dao;

import java.util.List;

import br.com.academiafit.entidade.Cliente;

public interface ClienteDAO {
		
		public String incluir(Cliente cliente);
		public String alterar(Cliente cliente);
		public List<Cliente> listarTodos();
		String excluir(long index);
}