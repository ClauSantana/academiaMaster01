package br.com.academiafit.vo.converter;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import br.com.academiafit.entidade.Cliente;
import br.com.academiafit.vo.ClienteVO;

public class ConverterCliente {
	public static Cliente ConverterClienteVoParaCliente(ClienteVO clienteVO){
		
		Cliente cliente = new Cliente();
		
		cliente.setId(clienteVO.getId());
		cliente.setCpf(clienteVO.getCpf());
		cliente.setNome(clienteVO.getNome());
		cliente.setDtnascimento(clienteVO.getDtnascimento()); 
		cliente.setEnd(clienteVO.getEnd());
		cliente.setBairro(clienteVO.getBairro());
		cliente.setCidade(clienteVO.getCidade());
		cliente.setEstado(clienteVO.getEstado());
		cliente.setFone(clienteVO.getFone());
		cliente.setSexo(clienteVO.getSexo());
		cliente.setDatacadastro(clienteVO.getDatacadastro());
		
		return cliente;		
	}


	public static ClienteVO ConverterClienteParaVO(Cliente cliente){
		ClienteVO clienteVO = new ClienteVO();
		
		clienteVO.setId(cliente.getId());
		clienteVO.setCpf(cliente.getCpf());
		clienteVO.setNome(cliente.getNome());
		clienteVO.setDtnascimento(cliente.getDtnascimento()); 
		clienteVO.setEnd(cliente.getEnd());
		clienteVO.setBairro(cliente.getBairro());
		clienteVO.setCidade(cliente.getCidade());
		clienteVO.setEstado(cliente.getEstado());
		clienteVO.setFone(cliente.getFone());
		clienteVO.setSexo(cliente.getSexo());
		clienteVO.setDatacadastro(cliente.getDatacadastro());
		
		return clienteVO;

	}
	public static List<ClienteVO> ConverterClienteParaListaVo(List<Cliente> listaEntidade){

		List<ClienteVO> listClienteVO = new ArrayList<ClienteVO>();
		if(listaEntidade != null && !listaEntidade.isEmpty()){
			for(Cliente cliente : listaEntidade){
				ClienteVO clienteVO = ConverterClienteParaVO(cliente);
				listClienteVO.add(clienteVO);
			}
		}
		return listClienteVO;

	}
}