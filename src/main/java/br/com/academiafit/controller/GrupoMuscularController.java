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

import br.com.academiafit.service.GrupoMuscularService;
import br.com.academiafit.vo.GrupoMuscularVO;

@ManagedBean(name = "grupomuscularMbean")
@SessionScoped
public class GrupoMuscularController extends AbstractController {
	
	//declara a tela listar_todos
	public static String TELA_LISTAR_TODOS = "/grupomuscular/listarTodos.xhtml";
	
	//declara a tela cadastro
	public static String TELA_CADASTRAR_GRUPO_MUSCULAR = "/grupomuscular/cadastrar_grupomuscular.xhtml";

	@Autowired //informa as variaveis que iram acessar a SERVICE e a SERVICE IMPL

	private GrupoMuscularService grupoMuscularService; //tem acesso a service

	private List<GrupoMuscularVO> listGrupoMuscularVO; //lista do banco

	private GrupoMuscularVO grupomuscular = new GrupoMuscularVO(); //é o que vem da tela do usuario


	@PostConstruct //a primeira coisa que executa quando chama a Classe

	private void init() {
		super.getConfigSpring(); //SUPER - vai para entidade Pai nesse caso ABSTRACT - ConfgSpring - Permissão para acessar a ABSTRACT 	
	}

	//Get e Set dos atributos para acessar a SERVICE e IMPL
	public List<GrupoMuscularVO> getListGrupoMuscularVO() {
		return listGrupoMuscularVO;
	}

	public void setListGrupoMuscularVO(List<GrupoMuscularVO> listGrupoMuscularVO) {
		this.listGrupoMuscularVO = listGrupoMuscularVO;
	}

	public GrupoMuscularVO getGrupomuscular() {
		return grupomuscular;
	}

	public void setGrupomuscular(GrupoMuscularVO grupomuscular) {
		this.grupomuscular = grupomuscular;
	}

	//chama a tela cadastro
	public String chamarTelaCadastro(){
		return TELA_CADASTRAR_GRUPO_MUSCULAR;
	}

	public String chamarTelaListarTodos(){
		listGrupoMuscularVO = grupoMuscularService.listarTodos(); 
		return TELA_LISTAR_TODOS;
	}	

	public String incluir() {

		grupoMuscularService.incluir(grupomuscular);

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,null,"Grupo Muscular salvo com sucesso!"));

		//this.limparCampos();
		return "";
	}

	public String excluir(GrupoMuscularVO grupomuscularVO){
		if(grupomuscularVO != null && grupomuscularVO.getId() != 0){
			this.grupoMuscularService.excluir(grupomuscularVO);		
		}
		this.listGrupoMuscularVO = grupoMuscularService.listarTodos();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,null,"Grupo Muscular excluido com sucesso!"));
		return "";
	}

	private void limparCampos() {
		this.getGrupomuscular().setMusculo(null);
		this.getGrupomuscular().setExercicio(null);
	}
}


