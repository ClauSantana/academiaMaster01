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

import br.com.academiafit.entidade.AvaliacaoFisica;
import br.com.academiafit.exception.BusinessException;
import br.com.academiafit.service.AvaliacaoFisicaService;
import br.com.academiafit.vo.AvaliacaoFisicaVO;

@ManagedBean(name = "avaliacaoFisicaMbean")
@SessionScoped
public class AvaliacaoFisicaController extends AbstractController{
	public static String TELA_LISTA_TODOS = "/avaliacaoFisica/listarTodos.xhtml";
	public static String TELA_CADASTRAR = "/avaliacaoFisica/cadastrar_avaliacaoFisica.xhtml";

	@Autowired
	private AvaliacaoFisicaService avaliacaoFisicaService;
	
	private List<AvaliacaoFisicaVO> listaAvaliacaoFisicaVO;

	private AvaliacaoFisicaVO avaliacaoFisica = new AvaliacaoFisicaVO();

	@PostConstruct
	private void init() {
		// obtem o objeto da superclasse
		super.getConfigSpring();
	}

	public AvaliacaoFisicaVO getAvaliacaoFisica() {
		return avaliacaoFisica;
	}

	public void setAvaliacaoFisica(AvaliacaoFisicaVO employee) {
		this.avaliacaoFisica = avaliacaoFisica;
	}

	public List<AvaliacaoFisicaVO> getListaAvaliacaoFisicaVO() {
		return listaAvaliacaoFisicaVO;
	}

	private void limparCampos() {
		this.avaliacaoFisica.setAltura(0);
		this.avaliacaoFisica.setBracoDireito(0);
		this.avaliacaoFisica.setBracoEsquerdo(0);
		this.avaliacaoFisica.setCintura(0);
		//this.avaliacaoFisica.setCliente(0);
		this.avaliacaoFisica.setCoxaDireito(0);
		this.avaliacaoFisica.setCoxaEsquerdo(0);
		this.avaliacaoFisica.setDataavaliacao(null);
		this.avaliacaoFisica.setPanturrilhaDireito(0);
		this.avaliacaoFisica.setPanturrilhaEsquerdo(0);
		this.avaliacaoFisica.setPeito(0);
		this.avaliacaoFisica.setPeso(0);
		this.avaliacaoFisica.setQuadril(0);
		this.avaliacaoFisica.setImc();	
	}

	public String chamarTelaCadastro(){
		return TELA_CADASTRAR;
	}
	
	public String chamarTelaListarTodos(){
		listaAvaliacaoFisicaVO = avaliacaoFisicaService.consultarTodos();
		
		System.out.println("AvaliacaoFisicaController-consultarTodos diz: ");
		for(AvaliacaoFisicaVO atual : listaAvaliacaoFisicaVO){
			System.out.println(atual.getId());
		}
		System.out.println("AvaliacaoFisicaController-consultarTodos terminou");
		
		return TELA_LISTA_TODOS;
	}

	public String incluir() {
		try{
			avaliacaoFisicaService.incluir(avaliacaoFisica);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null,"AvaliacaoFisica salvo com sucesso!"));

		}catch (BusinessException exception){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null,exception.getMessage()));
		}		

		this.limparCampos();
		return "";
	}

	public String excluir(AvaliacaoFisicaVO avaliacaoFisicaVO){		
		try{
			System.out.println(avaliacaoFisicaVO.getId());
			this.listaAvaliacaoFisicaVO = avaliacaoFisicaService.consultarTodos();
			avaliacaoFisicaService.excluir(avaliacaoFisicaVO);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null,"AvaliacaoFisica excluído com sucesso!"));

		}catch (BusinessException exception){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null,exception.getMessage()));
		}
		return "";
	}

	public String consultar(AvaliacaoFisicaVO avaliacaoFisicaVO){
		try {
			avaliacaoFisicaService.consultar(avaliacaoFisicaVO);

			List<AvaliacaoFisicaVO> listaSimples = new ArrayList<AvaliacaoFisicaVO> ();
			listaSimples.add(avaliacaoFisicaVO);
			this.listaAvaliacaoFisicaVO = listaSimples;

		} catch (BusinessException exception) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null,exception.getMessage()));

		}
		return "";
	}
}