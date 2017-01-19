package br.com.academiafit.vo.converter;

import java.util.ArrayList;
import java.util.List;

import br.com.academiafit.entidade.Professor;
import br.com.academiafit.vo.ProfessorVO;

public class ConverterProfessor {
	public static Professor ConverterProfessorVoParaProfessor(ProfessorVO professorVO){
		Professor professor = new Professor();
		
		professor.setId(professorVO.getId());
		professor.setCpf(professorVO.getCpf());
		professor.setNome(professorVO.getNome());
		professor.setDtnascimento(professorVO.getDtnascimento()); 
		professor.setEnd(professorVO.getEnd());
		professor.setBairro(professorVO.getBairro());
		professor.setCidade(professorVO.getCidade());
		professor.setEstado(professorVO.getEstado());
		professor.setFone(professorVO.getFone());
		professor.setSexo(professorVO.getSexo());
		professor.setDatacontrato(professorVO.getDatacontrato());
		professor.setEscolaridade(professorVO.getEscolaridade());
		professor.setHorario(professorVO.getHorario());
		
		return professor;
		
		
	}
		
	public static ProfessorVO ConverterProfessorParaVO(Professor professor){
		ProfessorVO professorVO = new ProfessorVO();
		
		professorVO.setId(professor.getId());
		professorVO.setCpf(professor.getCpf());
		professorVO.setNome(professor.getNome());
		professorVO.setDtnascimento(professor.getDtnascimento()); 
		professorVO.setEnd(professor.getEnd());
		professorVO.setBairro(professor.getBairro());
		professorVO.setCidade(professor.getCidade());
		professorVO.setEstado(professor.getEstado());
		professorVO.setFone(professor.getFone());
		professorVO.setSexo(professor.getSexo());
		professorVO.setId(professor.getId());
		professorVO.setHorario(professor.getHorario());
		
		return professorVO;
	
}
     public static List<ProfessorVO> ConverterProfessorListaParaVo(List<Professor> listaEntidade){
		
		List<ProfessorVO> listProfessorVO = new ArrayList<ProfessorVO>();
		if(listaEntidade != null && !listaEntidade.isEmpty()){
			for(Professor professor : listaEntidade){
				ProfessorVO professorVO = ConverterProfessorParaVO(professor);
				listProfessorVO.add(professorVO);
			}
		}
		return listProfessorVO;
		
	}
	
}