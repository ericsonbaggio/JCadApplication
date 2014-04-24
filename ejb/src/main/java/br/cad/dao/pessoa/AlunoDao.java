package br.cad.dao.pessoa;

import java.util.List;

import br.cad.model.academico.Turma;
import br.cad.model.pessoa.Aluno;

/**
 * Definição de Dao de Aluno
 * 
 * @author Will
 * @since 1.0
 */
public interface AlunoDao extends PessoaPapelDao<Aluno> {
	
	/*
	 ********************************************************************************************************************
	 ************************************************* Metodos Abstratos ************************************************
	 ********************************************************************************************************************
	 */
	public List<Aluno> findAlunoByTurma(Turma turma);
	
}
