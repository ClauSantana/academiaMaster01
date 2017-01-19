package br.com.academiafit.service.impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academiafit.dao.FuncionarioDAO;
import br.com.academiafit.dao.impl.AbstractDAOImpl;
import br.com.academiafit.service.FuncionarioService;
import br.com.academiafit.vo.FuncionarioVO;
import br.com.academiafit.vo.converter.ConverterFuncionario;



@Service
public class FuncionarioServiceImpl extends AbstractDAOImpl implements FuncionarioService {

	@Autowired(required=true)
	private FuncionarioDAO dao;

	@Override
	@Transactional
	public void incluir(FuncionarioVO funcionario) {
		String msg = new String (dao.incluir(ConverterFuncionario.ConverterFuncionarioVoParaFuncionario(funcionario)));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));	
		//return null;
	}

	@Override
	@Transactional
	public void excluir(FuncionarioVO funcionario) {
		String msg = new String (dao.excluir(funcionario.getId()));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
		//return null;
	}

	@Override
	@Transactional
	public void alterar(FuncionarioVO funcionario) {
		String msg = new String (dao.alterar(ConverterFuncionario.ConverterFuncionarioVoParaFuncionario(funcionario)));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
		//return null;
	}

	@Override
	public List<FuncionarioVO> listarTodos() {
		return ConverterFuncionario.ConverterFuncionarioListaParaVo(dao.listarTodos());

	}


}
