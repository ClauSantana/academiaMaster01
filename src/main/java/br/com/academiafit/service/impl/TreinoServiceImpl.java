package br.com.academiafit.service.impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academiafit.dao.TreinoDAO;
import br.com.academiafit.dao.TreinoDAO;
import br.com.academiafit.entidade.Treino;
import br.com.academiafit.exception.BusinessException;
import br.com.academiafit.service.TreinoService;
import br.com.academiafit.vo.TreinoVO;
import br.com.academiafit.vo.TreinoVO;
import br.com.academiafit.vo.converter.ConverterTreino;
import br.com.academiafit.vo.converter.ConverterTreino;

@Service
public class TreinoServiceImpl implements TreinoService{
	@Autowired(required=true)
	private TreinoDAO dao;

	@Transactional
	public void incluir(TreinoVO treinoVO) throws BusinessException {
		boolean status = dao.consultar(treinoVO.getId());
		if (status){
			throw new BusinessException("Nickname já está sendo usado por outro treino!");
		}else{
			Treino treino = ConverterTreino.ConverterVoParaTreino(treinoVO);
			dao.incluir(treino);
		}
	}

	@Transactional
	public void excluir(TreinoVO treinoVO) throws BusinessException{
		boolean status = dao.consultar(treinoVO.getId());
		System.out.println(treinoVO.getId() + " - " + status);

		if (status){
			Treino treino = ConverterTreino.ConverterVoParaTreino(treinoVO);
			System.out.println(treino.getId());
			dao.excluir(treino.getId());

		}else{
			System.out.println("nada!");
			throw new BusinessException("Treino não foi encontrado!");

		}

	}

	@Transactional
	public void alterar(TreinoVO treinoVO) throws BusinessException{
		boolean status = dao.consultar(treinoVO.getId());

		if (status){
			Treino treino = ConverterTreino.ConverterVoParaTreino(treinoVO);
			dao.alterar(treino);

		}else{
			throw new BusinessException("Treino não foi encontrado!");

		}

	}

	@Transactional
	public TreinoVO consultar(TreinoVO treinoVO) throws BusinessException{
		boolean status = dao.consultar(treinoVO.getId());

		if (status){
			Treino treino = ConverterTreino.ConverterVoParaTreino(treinoVO);
			List<TreinoVO> lista = ConverterTreino.ConverterListaTreinoParaListaVo(dao.consultarTodos());
			for (TreinoVO treinoAtual : lista){
				if (treinoAtual.getId() == treinoVO.getId()){
					return treinoVO; 
				}
			}
		}else{
			throw new BusinessException("Treino não foi encontrado!");
		}
		return null;
	}

	@Transactional
	public List<TreinoVO> consultarTodos() {
		List<Treino> listaTreino = dao.consultarTodos();
		return ConverterTreino.ConverterListaTreinoParaListaVo(listaTreino);
	}
}
