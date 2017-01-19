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
import br.com.academiafit.service.UsuarioService;
import br.com.academiafit.vo.UsuarioVO;

@ManagedBean(name = "usuarioMbean")
@SessionScoped
public class UsuarioController extends AbstractController{

	public static String TELA_LISTA_TODOS = "/usuario/listarTodos.xhtml";
	public static String TELA_CADASTRAR = "/usuario/cadastrar_usuario.xhtml";

	@Autowired
	private UsuarioService usuarioService;

	private List<UsuarioVO> listaUsuarioVO;

	private UsuarioVO usuario = new UsuarioVO();

	@PostConstruct
	private void init() {
		// obtem o objeto da superclasse
		super.getConfigSpring();
	}

	public UsuarioVO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioVO employee) {
		this.usuario = usuario;
	}

	public List<UsuarioVO> getListaUsuarioVO() {
		return listaUsuarioVO;
	}

	private void limparCampos() {
		this.getUsuario().setNickname(null);
		this.getUsuario().setSenha(null);
	}

	public String chamarTelaCadastro(){
		return TELA_CADASTRAR;
	}

	public String chamarTelaListarTodos(){
		listaUsuarioVO = usuarioService.consultarTodos();
		return TELA_LISTA_TODOS;
	}

	public String incluir() {
		try{
			usuarioService.incluir(usuario);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null,"Usuario salvo com sucesso!"));

		}catch (BusinessException exception){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null,exception.getMessage()));
		}		

		this.limparCampos();
		return "";
	}

	public String excluir(UsuarioVO usuarioVO){		
		try{
			usuarioService.excluir(usuarioVO);
			this.listaUsuarioVO = usuarioService.consultarTodos();

		}catch (BusinessException exception){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null,exception.getMessage()));
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null,"Usuario salvo com sucesso!"));
		return "";
	}

	public String consultar(UsuarioVO usuarioVO){
		try {
			usuarioService.consultar(usuarioVO);

			List<UsuarioVO> listaSimples = new ArrayList<UsuarioVO> ();
			listaSimples.add(usuarioVO);
			this.listaUsuarioVO = listaSimples;

		} catch (BusinessException exception) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null,exception.getMessage()));

		}
		return "";
	}
}