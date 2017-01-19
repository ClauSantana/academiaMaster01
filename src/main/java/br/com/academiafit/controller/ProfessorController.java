package br.com.academiafit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.academiafit.exception.BusinessException;
import br.com.academiafit.service.ProfessorService;
import br.com.academiafit.vo.ProfessorVO;

@ManagedBean(name = "professorMbean")
@SessionScoped
public class ProfessorController extends AbstractController{

	public static String TELA_LISTA_TODOS = "/professor/listarTodos.xhtml";
	public static String TELA_CADASTRAR = "/professor/cadastrar_professor.xhtml";

	@Autowired
	private ProfessorService professorService;

	private List<ProfessorVO> listaProfessorVO;

	private ProfessorVO professor = new ProfessorVO();

	@PostConstruct
	private void init() {
		// obtem o objeto da superclasse
		super.getConfigSpring();
	}

	public ProfessorVO getProfessor() {
		return professor;
	}

	public void setProfessor(ProfessorVO employee) {
		this.professor = professor;
	}

	public List<ProfessorVO> getListaProfessorVO() {
		return listaProfessorVO;
	}

	public String chamarTelaCadastro(){
		return TELA_CADASTRAR;
	}

	public String chamarTelaListarTodos(){
		listaProfessorVO = professorService.listarTodos();
		return TELA_LISTA_TODOS;
	}

	public String incluir() {
		professorService.incluir(professor);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null,"Professor salvo com sucesso!"));
		return "";
	}

	public String excluir(ProfessorVO professorVO){		
		professorService.excluir(professorVO);
		this.listaProfessorVO = professorService.listarTodos();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null,"Professor salvo com sucesso!"));
		return "";
	}
}
