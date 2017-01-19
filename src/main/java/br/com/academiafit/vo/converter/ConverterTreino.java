package br.com.academiafit.vo.converter;

import java.util.ArrayList;
import java.util.List;

import br.com.academiafit.entidade.Treino;
import br.com.academiafit.vo.TreinoVO;

public class ConverterTreino {
	public static Treino ConverterVoParaTreino(TreinoVO treinoVO){
		Treino treino = new Treino();
		treino.setId(treinoVO.getId());
		treino.setDiasemana(treinoVO.getDiasemana());
		treino.setRepeticoes(treinoVO.getRepeticoes());
		treino.setSeries(treinoVO.getSeries());
		
		return treino;
	}

	public static TreinoVO ConverterTreinoParaVO(Treino treino){
		TreinoVO treinoVO = new TreinoVO();
		treinoVO.setId(treino.getId());
		treinoVO.setDiasemana(treino.getDiasemana());
		treinoVO.setRepeticoes(treino.getRepeticoes());
		treinoVO.setSeries(treino.getSeries());
		
		return treinoVO;
	}

	public static List<TreinoVO> ConverterListaTreinoParaListaVo(List<Treino> listaEntidade){

		List<TreinoVO> listTreinoVO = new ArrayList<TreinoVO>();
		if(listaEntidade != null && !listaEntidade.isEmpty()){
			for(Treino treino : listaEntidade){
				TreinoVO treinoVO = ConverterTreinoParaVO(treino);
				listTreinoVO.add(treinoVO);
			}
		}
		return listTreinoVO;
	}
}
