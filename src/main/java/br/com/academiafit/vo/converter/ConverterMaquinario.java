package br.com.academiafit.vo.converter;

import java.util.ArrayList;
import java.util.List;

import br.com.academiafit.entidade.Maquinario;
import br.com.academiafit.vo.MaquinarioVO;


public class ConverterMaquinario {
	
	public static Maquinario ConverterMaquinarioVoParaMaquinario(MaquinarioVO maquinarioVO) {
		Maquinario maquinario = new Maquinario();
		maquinario.setId(maquinarioVO.getId());
		maquinario.setNome(maquinarioVO.getNome());
		
		return maquinario;
}		
		
	public static MaquinarioVO ConverterMaquinarioParaMaquinarioVO(Maquinario maquinario) {
		MaquinarioVO maquinarioVO = new MaquinarioVO();	
		maquinarioVO.setId(maquinario.getId());
		return maquinarioVO;
		
	}
	
	public static List<MaquinarioVO> ConverterMaquinaListaParaListaVO (List<Maquinario> listaEntidade){
		List<MaquinarioVO> listMaquinarioVO = new ArrayList <MaquinarioVO>();
		if (listaEntidade != null && listaEntidade.isEmpty()){
			for (Maquinario maquinario : listaEntidade){
				MaquinarioVO  maquinarioVO  = ConverterMaquinarioParaMaquinarioVO(maquinario);
				listMaquinarioVO.add(maquinarioVO);
			}
			
		}
		
		return listMaquinarioVO;
		
	}
		
	

}
