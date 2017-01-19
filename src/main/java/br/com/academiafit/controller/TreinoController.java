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

import br.com.academiafit.exception.BusinessException;
import br.com.academiafit.service.TreinoService;
import br.com.academiafit.vo.TreinoVO;

@ManagedBean(name = "treinoMbean")
@SessionScoped
public class TreinoController extends AbstractController {
	
	public static String TELA_LISTA_TODOS = "/treino/listarTodos.xhtml";
	public static String TELA_CADASTRAR = "/treino/cadastrar_treino.xhtml";

	@Autowired
	private TreinoService treinoService;

	private List<TreinoVO> listaTreinoVO;

	private TreinoVO treino = new TreinoVO();

	@PostConstruct
	private void init() {
		// obtem o objeto da superclasse
		super.getConfigSpring();
	}

	public TreinoVO getTreino() {
		return treino;
	}

	public void setTreino(TreinoVO employee) {
		this.treino = treino;
	}

	public List<TreinoVO> getListaTreinoVO() {
		return listaTreinoVO;
	}

	private void limparCampos() {
		this.getTreino().setDiasemana(null);
		this.getTreino().setRepeticoes(0);
		this.getTreino().setRepeticoes(0);
	}

	public String chamarTelaCadastro(){
		return TELA_CADASTRAR;
	}

	public String chamarTelaListarTodos(){
		listaTreinoVO = treinoService.consultarTodos();
		return TELA_LISTA_TODOS;
	}

	public String incluir() {
		try{
			treinoService.incluir(treino);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null,"Treino salvo com sucesso!"));

		}catch (BusinessException exception){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null,exception.getMessage()));
		}		

		this.limparCampos();
		return "";
	}

	public String excluir(TreinoVO treinoVO){		
		try{
			System.out.println(treinoVO.getId());
			this.listaTreinoVO = treinoService.consultarTodos();
			treinoService.excluir(treinoVO);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null,"Treino excluído com sucesso!"));

		}catch (BusinessException exception){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null,exception.getMessage()));
		}
		return "";
	}

	public String consultar(TreinoVO treinoVO){
		try {
			treinoService.consultar(treinoVO);

			List<TreinoVO> listaSimples = new ArrayList<TreinoVO> ();
			listaSimples.add(treinoVO);
			this.listaTreinoVO = listaSimples;

		} catch (BusinessException exception) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null,exception.getMessage()));

		}
		return "";
	}
}
