package br.com.academiafit.service;
import java.util.List;
import br.com.academiafit.vo.MaquinarioVO;


public interface MaquinarioService {
	
	
	public void incluir(MaquinarioVO maquinario);
	public void excluir(MaquinarioVO maquinario);
	public void alterar (MaquinarioVO maquinario);
	public List<MaquinarioVO> listarTodos();


}
