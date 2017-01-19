package br.com.academiafit.service.impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.academiafit.dao.MaquinarioDAO;
import br.com.academiafit.dao.impl.AbstractDAOImpl;
import br.com.academiafit.service.MaquinarioService;
import br.com.academiafit.vo.MaquinarioVO;
import br.com.academiafit.vo.converter.ConverterMaquinario;

public class MaquinarioServiceImpl extends AbstractDAOImpl implements MaquinarioService{
	@Autowired(required=true)
	private MaquinarioDAO dao;
	
	

	@Override
	@Transactional
	public void incluir(MaquinarioVO maquinario) {
		String msg = new String (dao.incluir (ConverterMaquinario.ConverterMaquinarioVoParaMaquinario(maquinario)));
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
		
	}

	@Override
	public void excluir(MaquinarioVO maquinario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(MaquinarioVO maquinario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MaquinarioVO> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
