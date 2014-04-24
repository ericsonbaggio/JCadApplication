package br.cad.dao.academico;

import java.util.List;

import br.cad.dao.Dao;
import br.cad.model.academico.Nota;
import br.cad.model.pessoa.Aluno;

/**
 * Definição de Dao do Nota
 * 
 * @author WilliamRodrigues <br>
 *         {@link william.rodrigues@live.fae.edu}
 * @since 1.0
 */
public interface NotaDao extends Dao<Nota> {

	/*
	 * *******************************************************************************************************************
	 * ************************************************ Metodos Abstratos ************************************************
	 * *******************************************************************************************************************
	 */

	public List<Nota> findAllNotasByAluno(Aluno aluno);
}
