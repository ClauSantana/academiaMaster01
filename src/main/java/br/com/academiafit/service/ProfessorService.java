package br.com.academiafit.service;
import java.util.List;


import br.com.academiafit.vo.ProfessorVO;

public interface ProfessorService {
	
	
	public void incluir(ProfessorVO professor);
	public void excluir(ProfessorVO professor);
	public void alterar (ProfessorVO professor);
	public List<ProfessorVO> listarTodos();


}
