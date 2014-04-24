package br.cad.dao.academico;

import java.util.List;

import br.cad.dao.Dao;
import br.cad.model.academico.Chamada;
import br.cad.model.pessoa.Aluno;

/**
 * Definição de Dao do Chamada
 * 
 * @author WilliamRodrigues <br>
 *         {@link william.rodrigues@live.fae.edu}
 * @since 1.0
 */
public interface ChamadaDao extends Dao<Chamada> {

	/*
	 * *******************************************************************************************************************
	 * ************************************************ Metodos Abstratos ************************************************
	 * *******************************************************************************************************************
	 */

	public List<Chamada> findAllChamadasByAluno(Aluno aluno);
}
