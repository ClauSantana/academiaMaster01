package br.com.academiafit.dao;

import java.util.List;


import br.com.academiafit.entidade.GrupoMuscular;
import br.com.academiafit.vo.GrupoMuscularVO;


public interface GrupoMuscularDAO {

		public String incluir(GrupoMuscular grupoMuscular);
		public String alterar(GrupoMuscular grupomuscular);
		public String excluir(long index);
		public List<GrupoMuscular> consultarTodos();
		

}