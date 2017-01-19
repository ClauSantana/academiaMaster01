package br.com.academiafit.service.impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.academiafit.dao.ProfessorDAO;
import br.com.academiafit.dao.impl.AbstractDAOImpl;
import br.com.academiafit.service.ProfessorService;
import br.com.academiafit.vo.ProfessorVO;
import br.com.academiafit.vo.converter.ConverterProfessor;



@Service
public class ProfessorServiceImpl extends AbstractDAOImpl implements ProfessorService{

	@Autowired(required=true)
	private ProfessorDAO dao;
	
	@Override
	@Transactional
	public void incluir(ProfessorVO professor) {
		String msg = new String (dao.incluir(ConverterProfessor.ConverterProfessorVoParaProfessor(professor)));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));	
		//return null;
	}

	@Override
	@Transactional
	public void excluir(ProfessorVO professor) {
		String msg = new String (dao.excluir(professor.getId()));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
		//return null;
	}

	@Override
	@Transactional
	public void alterar(ProfessorVO professor) {
		String msg = new String (dao.alterar(ConverterProfessor.ConverterProfessorVoParaProfessor(professor)));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
		//return null;
	
	}

	@Override
	public List<ProfessorVO> listarTodos() {
		return ConverterProfessor.ConverterProfessorListaParaVo(dao.listarTodos());
	//	return null;
	}
	
	
	
}
