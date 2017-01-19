package br.com.academiafit.service;
import java.util.List;
import br.com.academiafit.vo.PessoaVO;

public interface PessoaService {
	public void salvar(PessoaVO pessoa);
	public String incluir(PessoaVO pessoa);
	public String excluir (int index);
	public List<PessoaVO> consultarTodos();
	String excluir(PessoaVO pessoa);
	public List<PessoaVO> listarTodos();


}
