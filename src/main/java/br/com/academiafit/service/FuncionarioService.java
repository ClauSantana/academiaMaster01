package br.com.academiafit.service;
import java.util.List;

import br.com.academiafit.exception.BusinessException;
import br.com.academiafit.vo.FuncionarioVO;



public interface FuncionarioService {
	
	
	public void incluir(FuncionarioVO funcionarioVO) throws BusinessException;
	public void excluir(FuncionarioVO funcionarioVO) throws BusinessException;
	public void alterar(FuncionarioVO funcionarioVO) throws BusinessException;
	public List<FuncionarioVO> listarTodos();

}
