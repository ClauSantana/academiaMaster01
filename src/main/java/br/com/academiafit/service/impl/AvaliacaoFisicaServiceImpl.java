package br.com.academiafit.service.impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academiafit.dao.AvaliacaoFisicaDAO;
import br.com.academiafit.entidade.AvaliacaoFisica;
import br.com.academiafit.entidade.Treino;
import br.com.academiafit.exception.BusinessException;
import br.com.academiafit.service.AvaliacaoFisicaService;
import br.com.academiafit.vo.AvaliacaoFisicaVO;
import br.com.academiafit.vo.TreinoVO;
import br.com.academiafit.vo.converter.ConverterAvaliacaoFisica;
import br.com.academiafit.vo.converter.ConverterTreino;

@Service
public class AvaliacaoFisicaServiceImpl implements AvaliacaoFisicaService{
	@Autowired(required=true)
	private AvaliacaoFisicaDAO dao;

	@Transactional
	public void incluir(AvaliacaoFisicaVO avaliacaoFisicaVO) throws BusinessException {
		boolean status = dao.consultar(avaliacaoFisicaVO.getId());
		if (status){
			throw new BusinessException("ID já está sendo usado por outro avaliacaoFisica!");
		}else{
			AvaliacaoFisica avaliacaoFisica = ConverterAvaliacaoFisica.ConverterVoParaAvaliacaoFisica(avaliacaoFisicaVO);
			dao.incluir(avaliacaoFisica);
		}
	}

	@Transactional
	public void excluir(AvaliacaoFisicaVO avaliacaoFisicaVO) throws BusinessException{
		boolean status = dao.consultar(avaliacaoFisicaVO.getId());
		System.out.println(avaliacaoFisicaVO.getId() + " - " + status);

		if (status){
			dao.excluir(avaliacaoFisicaVO.getId());

		}else{
			System.out.println("nada!");
			throw new BusinessException("Avaliação Física não foi encontrado!");

		}

	}

	@Transactional
	public void alterar(AvaliacaoFisicaVO avaliacaoFisicaVO) throws BusinessException{
		boolean status = dao.consultar(avaliacaoFisicaVO.getId());

		if (status){
			AvaliacaoFisica avaliacaoFisica = ConverterAvaliacaoFisica.ConverterVoParaAvaliacaoFisica(avaliacaoFisicaVO);
			dao.alterar(avaliacaoFisica);

		}else{
			throw new BusinessException("Avaliação Física não foi encontrado!");

		}
	}

	@Transactional
	public AvaliacaoFisicaVO consultar(AvaliacaoFisicaVO avaliacaoFisicaVO) throws BusinessException{
		boolean status = dao.consultar(avaliacaoFisicaVO.getId());

		if (status){
			AvaliacaoFisica avaliacaoFisica = ConverterAvaliacaoFisica.ConverterVoParaAvaliacaoFisica(avaliacaoFisicaVO);
			List<AvaliacaoFisicaVO> lista = ConverterAvaliacaoFisica.ConverterListaAvaliacaoFisicaParaListaVo(dao.consultarTodos());
			for (AvaliacaoFisicaVO avaliacaoFisicaAtual : lista){
				if (avaliacaoFisicaAtual.getId() == avaliacaoFisicaVO.getId()){
					return avaliacaoFisicaVO; 
				}
			}
		}else{
			throw new BusinessException("Avaliação Física não foi encontrado!");
		}
		return null;
	}

	@Transactional
	public List<AvaliacaoFisicaVO> consultarTodos() {
		List<AvaliacaoFisica> listaAvaliacoes = dao.consultarTodos();
		return ConverterAvaliacaoFisica.ConverterListaAvaliacaoFisicaParaListaVo(listaAvaliacoes);
	}
}