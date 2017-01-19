package br.com.academiafit.vo.converter;

import java.util.ArrayList;
import java.util.List;

import br.com.academiafit.entidade.Funcionario;
import br.com.academiafit.vo.FuncionarioVO;

public class ConverterFuncionario {

	public static Funcionario ConverterFuncionarioVoParaFuncionario(FuncionarioVO funcionarioVO){
		Funcionario funcionario = new Funcionario();
		
		funcionarioVO.setId(funcionario.getId());
		funcionarioVO.setCpf(funcionario.getCpf());
		funcionarioVO.setNome(funcionario.getNome());
		funcionarioVO.setDtnascimento(funcionario.getDtnascimento()); 
		funcionarioVO.setEnd(funcionario.getEnd());
		funcionarioVO.setBairro(funcionario.getBairro());
		funcionarioVO.setCidade(funcionario.getCidade());
		funcionarioVO.setEstado(funcionario.getEstado());
		funcionarioVO.setFone(funcionario.getFone());
		funcionarioVO.setSexo(funcionario.getSexo());
		funcionario.setDatacontrato(funcionarioVO.getDatacontrato());
		funcionario.setEscolaridade(funcionarioVO.getEscolaridade());
		
		return funcionario;
	
	}
	
	
	public static FuncionarioVO ConverterFuncionarioParaVO(Funcionario funcionario){
		FuncionarioVO funcionarioVO = new FuncionarioVO();
		
		funcionario.setId(funcionarioVO.getId());
		funcionario.setCpf(funcionarioVO.getCpf());
		funcionario.setNome(funcionarioVO.getNome());
		funcionario.setDtnascimento(funcionarioVO.getDtnascimento()); 
		funcionario.setEnd(funcionarioVO.getEnd());
		funcionario.setBairro(funcionarioVO.getBairro());
		funcionario.setCidade(funcionarioVO.getCidade());
		funcionario.setEstado(funcionarioVO.getEstado());
		funcionario.setFone(funcionarioVO.getFone());
		funcionario.setSexo(funcionarioVO.getSexo());	
		funcionario.setDatacontrato(funcionarioVO.getDatacontrato());
		funcionario.setEscolaridade(funcionarioVO.getEscolaridade());
		
		
		return funcionarioVO;
	
}
     public static List<FuncionarioVO> ConverterFuncionarioListaParaVo(List<Funcionario> listaEntidade){
		
		List<FuncionarioVO> listFuncionarioVO = new ArrayList<FuncionarioVO>();
		if(listaEntidade != null && !listaEntidade.isEmpty()){
			for(Funcionario funcionario : listaEntidade){
				FuncionarioVO funcionarioVO = ConverterFuncionarioParaVO(funcionario);
				listFuncionarioVO.add(funcionarioVO);
			}
		}
		return listFuncionarioVO;
		
	}
	
}