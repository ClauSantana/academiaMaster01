package br.com.academiafit.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.academiafit.exception.BusinessException;
import br.com.academiafit.service.ClienteService;
import br.com.academiafit.vo.ClienteVO;
import br.com.academiafit.vo.UsuarioVO;


@ManagedBean (name = "clienteMbean")
@SessionScoped
public class ClienteController extends AbstractController {
	
	public static String TELA_LISTAR_TODOS = "/cliente/listarTodos.xhtml";
	public static String TELA_CADASTRAR = "/cliente/cadastrar_cliente.xhtml";
	
	@Autowired
	private ClienteService clienteService;
	
	private List<ClienteVO> listaClienteVO;
	
	private ClienteVO cliente = new ClienteVO();
	
	@PostConstruct
	private void init() {
		super.getConfigSpring();
	}
	
	public ClienteVO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteVO employee) {
		this.cliente = cliente;
	}
	
	public List<ClienteVO> getListaClienteVO() {
		return listaClienteVO;
	}

	
	private void limparCampos() {
	}
	/*	this.getCliente().setAltura(null);
		this.getCliente().setDatacadastro(null);
		this.getCliente().setDesenvolvimento(null);
		this.getCliente().setPeso(null);
	}*/
	
	public String chamarTelaCadastro(){
		return TELA_CADASTRAR;
	}
	public String chamarTelaListarTodos(){
		listaClienteVO = clienteService.listarTodos();
		return TELA_LISTAR_TODOS;
	}
	
	public String incluir() throws BusinessException{
		clienteService.incluir(cliente);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null," Cliente incluido com sucesso!"));
		
/*		try{

		}catch (BusinessException exception){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null,exception.getMessage()));
		}		

		this.limparCampos();*/
		
		return "";
	}
	
	public String excluir(ClienteVO clienteVO) throws BusinessException{		
		try{
			clienteService.excluir(clienteVO);
			this.listaClienteVO = clienteService.listarTodos();

		}catch (BusinessException exception){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null,exception.getMessage()));
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null,"Cliente excluido com sucesso!"));
		return "";
	}
	
	
}
