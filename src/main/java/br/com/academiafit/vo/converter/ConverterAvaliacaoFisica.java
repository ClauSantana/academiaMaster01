package br.com.academiafit.vo.converter;

import java.util.ArrayList;
import java.util.List;

import br.com.academiafit.entidade.AvaliacaoFisica;
import br.com.academiafit.vo.AvaliacaoFisicaVO;

public class ConverterAvaliacaoFisica {
	public static AvaliacaoFisica ConverterVoParaAvaliacaoFisica(AvaliacaoFisicaVO avaliacaofisicaVO){
		AvaliacaoFisica avaliacaofisica = new AvaliacaoFisica();
		
		avaliacaofisica.setId(avaliacaofisicaVO.getId());
		avaliacaofisica.setAltura(avaliacaofisicaVO.getAltura());
		avaliacaofisica.setBracoDireito(avaliacaofisicaVO.getBracoDireito());
		avaliacaofisica.setBracoEsquerdo(avaliacaofisicaVO.getBracoEsquerdo());
		avaliacaofisica.setCintura(avaliacaofisicaVO.getCintura());
		avaliacaofisica.setCoxaDireito(avaliacaofisicaVO.getCoxaDireito());
		avaliacaofisica.setCoxaEsquerdo(avaliacaofisicaVO.getCoxaEsquerdo());
		avaliacaofisica.setDataavaliacao(avaliacaofisicaVO.getDataavaliacao());
		avaliacaofisica.setPanturrilhaDireito(avaliacaofisicaVO.getPanturrilhaDireito());
		avaliacaofisica.setPanturrilhaEsquerdo(avaliacaofisicaVO.getPanturrilhaEsquerdo());
		avaliacaofisica.setPeito(avaliacaofisicaVO.getPeito());
		avaliacaofisica.setPeso(avaliacaofisicaVO.getPeso());
		avaliacaofisica.setQuadril(avaliacaofisicaVO.getQuadril());
		avaliacaofisica.setImc();	
		
		return avaliacaofisica;
	}
	
	public static AvaliacaoFisicaVO ConverterAvaliacaoFisicaAvaliacaoFisicaParaVO(AvaliacaoFisica avaliacaoFisica){
		AvaliacaoFisicaVO avaliacaofisicaVO = new AvaliacaoFisicaVO();
		
		avaliacaofisicaVO.setId(avaliacaoFisica.getId());
		avaliacaofisicaVO.setAltura(avaliacaoFisica.getAltura());
		avaliacaofisicaVO.setBracoDireito(avaliacaoFisica.getBracoDireito());
		avaliacaofisicaVO.setBracoEsquerdo(avaliacaoFisica.getBracoEsquerdo());
		avaliacaofisicaVO.setCintura(avaliacaoFisica.getCintura());
		avaliacaofisicaVO.setCoxaDireito(avaliacaoFisica.getCoxaDireito());
		avaliacaofisicaVO.setCoxaEsquerdo(avaliacaoFisica.getCoxaEsquerdo());
		avaliacaofisicaVO.setDataavaliacao(avaliacaoFisica.getDataavaliacao());
		avaliacaofisicaVO.setPanturrilhaDireito(avaliacaoFisica.getPanturrilhaDireito());
		avaliacaofisicaVO.setPanturrilhaEsquerdo(avaliacaoFisica.getPanturrilhaEsquerdo());
		avaliacaofisicaVO.setPeito(avaliacaoFisica.getPeito());
		avaliacaofisicaVO.setPeso(avaliacaoFisica.getPeso());
		avaliacaofisicaVO.setQuadril(avaliacaoFisica.getQuadril());
		avaliacaofisicaVO.setImc();
		
		return avaliacaofisicaVO;
	}
	
	public static List<AvaliacaoFisicaVO> ConverterListaAvaliacaoFisicaParaListaVo(List<AvaliacaoFisica> listaEntidade){
		
		List<AvaliacaoFisicaVO> listAvaliacaoFisicaVO = new ArrayList<AvaliacaoFisicaVO>();
		if(listaEntidade != null && !listaEntidade.isEmpty()){
			for(AvaliacaoFisica avaliacaofisica : listaEntidade){
				AvaliacaoFisicaVO avaliacaofisicaVO = ConverterAvaliacaoFisicaAvaliacaoFisicaParaVO(avaliacaofisica);
				listAvaliacaoFisicaVO.add(avaliacaofisicaVO);
			}
		}
		return listAvaliacaoFisicaVO;
	}
}
