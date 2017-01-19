package br.com.academiafit.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.academiafit.exception.BusinessException;
import br.com.academiafit.service.FuncionarioService;
import br.com.academiafit.vo.FuncionarioVO;

@ManagedBean (name = "funcionarioMbean")
@SessionScoped
public class FuncionarioController extends AbstractController {

	public static String TELA_LISTAR_TODOS = "/funcionario/listarTodos.xhtml";
	public static String TELA_CADASTRAR = "/funcionario/cadastrar_funcionario.xhtml";
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	private List<FuncionarioVO> listaFuncionarioVO;
	private FuncionarioVO funcionario = new FuncionarioVO();

	
	@PostConstruct
	private void init() {
		super.getConfigSpring();
	}
	
	public FuncionarioVO getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(FuncionarioVO employee) {
		this.funcionario = funcionario;
	}

	public List<FuncionarioVO> getListaFuncionarioVO() {
		return listaFuncionarioVO;
	}

	private void limparCampos(){

	}

	public String chamarTelaCadastro(){
		return TELA_CADASTRAR;
	}

	public String chamarTelaListarTodos(){
		listaFuncionarioVO = funcionarioService.listarTodos();
		return TELA_LISTAR_TODOS;
	}
	
	public String incluir() throws BusinessException{
		try{
			funcionarioService.incluir(funcionario);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null,"Funcionario salvo com sucesso!"));

		}catch (BusinessException exception){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null,exception.getMessage()));
		}		

		this.limparCampos();
		return "";
	}

	public String excluir(FuncionarioVO funcionarioVO) throws BusinessException{		
		try{
			funcionarioService.excluir(funcionarioVO);
			this.listaFuncionarioVO = funcionarioService.listarTodos();

		}catch (BusinessException exception){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null,exception.getMessage()));
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null,"Cliente excluido com sucesso!"));
		return "";
	}

}

