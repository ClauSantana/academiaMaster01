package br.com.academiafit.dao;

import java.util.List;


import br.com.academiafit.entidade.Professor;


public interface ProfessorDAO {

		
		public String incluir(Professor professor);
		public String alterar(Professor professor);
		public String excluir (long index);
		public List<Professor> listarTodos();
		

}