package br.com.academiafit.service;
import java.util.List;

import br.com.academiafit.entidade.GrupoMuscular;
import br.com.academiafit.vo.GrupoMuscularVO;



public interface GrupoMuscularService {
	
	
	public void incluir(GrupoMuscularVO grupomuscular);
	public void excluir(GrupoMuscularVO grupomuscular);
	public void alterar (GrupoMuscularVO grupomuscular);
	public List<GrupoMuscularVO> listarTodos();
	


}
