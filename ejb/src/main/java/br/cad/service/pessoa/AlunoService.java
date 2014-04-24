package br.cad.service.pessoa;

import java.util.List;

import br.cad.model.academico.Turma;
import br.cad.model.pessoa.Aluno;

/**
 * 
 * @author WilliamRodrigues
 * 
 */
public interface AlunoService extends PessoaPapelService<Aluno> {

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Metodos *****************************************************
	 * *******************************************************************************************************************
	 */
	
	public List<Aluno> findAlunoByTurma(Turma turma);
}
