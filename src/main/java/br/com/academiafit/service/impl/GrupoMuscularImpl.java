package br.com.academiafit.service.impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academiafit.dao.GrupoMuscularDAO;
import br.com.academiafit.dao.impl.AbstractDAOImpl;
import br.com.academiafit.service.GrupoMuscularService;
import br.com.academiafit.vo.GrupoMuscularVO;
import br.com.academiafit.vo.converter.ConverterGrupoMuscular;

@Service
public class GrupoMuscularImpl extends AbstractDAOImpl implements GrupoMuscularService{
	@Autowired(required=true)
	private GrupoMuscularDAO dao;

	@Override
	@Transactional
	public void incluir(GrupoMuscularVO grupomuscular) {
		String msg = new String (dao.incluir(ConverterGrupoMuscular.ConverterGrupoMuscularVoParaGrupoMuscular(grupomuscular)));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
	}

	@Override
	@Transactional
	public void excluir(GrupoMuscularVO grupomuscular) {
		String msg = new String (dao.excluir(grupomuscular.getId()));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
	}

	@Override
	@Transactional
	public void alterar(GrupoMuscularVO grupomuscular) {
		String msg = new String (dao.alterar(ConverterGrupoMuscular.ConverterGrupoMuscularVoParaGrupoMuscular(grupomuscular)));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));

	}


	@Override
	public List<GrupoMuscularVO> listarTodos() {
		return ConverterGrupoMuscular.ConverterGrupoMuscularListaParaListaVO(dao.consultarTodos());

	}	


}
