package br.com.academiafit.vo.converter;

import java.util.ArrayList;
import java.util.List;

import br.com.academiafit.entidade.GrupoMuscular;
import br.com.academiafit.vo.GrupoMuscularVO;

public class ConverterGrupoMuscular {

	public static GrupoMuscular ConverterGrupoMuscularVoParaGrupoMuscular(GrupoMuscularVO grupomuscularVO) {
		GrupoMuscular grupomuscular = new GrupoMuscular();
		grupomuscular.setId(grupomuscularVO.getId());
		grupomuscular.setMusculo(grupomuscularVO.getMusculo());
		grupomuscular.setExercicios(grupomuscular.getExercicios());
			
		return grupomuscular;
	}
	
	public static GrupoMuscularVO ConverterGrupoMuscularParaGrupoMuscularVO(GrupoMuscular grupomuscular) {
		GrupoMuscularVO grupomuscularVO = new GrupoMuscularVO();
		grupomuscularVO.setId(grupomuscular.getId());
		grupomuscularVO.setMusculo(grupomuscular.getMusculo());
		grupomuscularVO.setExercicio(grupomuscular.getExercicios());
		
		return grupomuscularVO; 		
	}

	
	public static List<GrupoMuscularVO> ConverterGrupoMuscularListaParaListaVO (List<GrupoMuscular> listaEntidade){
		List<GrupoMuscularVO> listGrupoMuscularVO = new ArrayList <GrupoMuscularVO>();
		if (listaEntidade != null && listaEntidade.isEmpty()){
			for (GrupoMuscular grupomuscular : listaEntidade){
				GrupoMuscularVO  grupomuscularVO  = ConverterGrupoMuscularParaGrupoMuscularVO(grupomuscular);
				listGrupoMuscularVO.add(grupomuscularVO);
			}
			
		}
		
		return listGrupoMuscularVO;
		
	}
	
	
}
