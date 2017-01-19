package br.com.academiafit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.academiafit.service.MaquinarioService;
import br.com.academiafit.vo.MaquinarioVO;


@ManagedBean(name = "maquinarioMbean")
@SessionScoped
public class MaquinarioController extends AbstractController {
	public static String TELA_LISTAR_TODOS = "/maquinario/listarTodos.xhtml";
	public static String TELA_CADASTRAR_MAQUINARIO = "/maquinario/cadastrar_maquinario.xhtml";

	@Autowired
	private MaquinarioService maquinarioService;

	private List<MaquinarioVO> listMaquinarioVO;

	private MaquinarioVO maquinario = new MaquinarioVO();	


	public List<MaquinarioVO> getListMaquinarioVO() {
		return listMaquinarioVO;
	}

	public void setListMaquinarioVO(List<MaquinarioVO> listMaquinarioVO) {
		this.listMaquinarioVO = listMaquinarioVO;
	}

	public MaquinarioVO getMaquinario() {
		return maquinario;
	}

	public void setMaquinario(MaquinarioVO maquinario) {
		this.maquinario = maquinario;
	}

	@PostConstruct 
	private void init() {
		super.getConfigSpring();
	}


	public String chamarTelaCadastro(){
		return TELA_CADASTRAR_MAQUINARIO;
	}

	public String chamarTelaListarTodos(){
		listMaquinarioVO = maquinarioService.listarTodos();
		return TELA_LISTAR_TODOS;
	}	

	public String salvar() {
		maquinarioService.incluir(maquinario);

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,null,"Maquinario salvo com sucesso!"));
		return "";
	}

	public String excluir(MaquinarioVO maquinarioVO){
		if(maquinarioVO != null && maquinarioVO.getId() != 0){
			this.maquinarioService.excluir(maquinarioVO);	
		}

		this.listMaquinarioVO = maquinarioService.listarTodos();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,null,"Maquinario excluido com sucesso!"));
		return "";			
	}
	private void limparCampos() {
		this.getMaquinario().setNome(null);

	}
}
