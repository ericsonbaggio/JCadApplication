package br.cad.dao.academico;

import java.util.Date;
import java.util.List;

import br.cad.dao.Dao;
import br.cad.model.academico.Aula;
import br.cad.model.academico.Disciplina;

/**
 * Definição de Dao do Aula
 * 
 * @author WilliamRodrigues <br>
 *         {@link william.rodrigues@live.fae.edu}
 * @since 1.0
 */
public interface AulaDao extends Dao<Aula> {
	
	/*
	 * *******************************************************************************************************************
	 * ************************************************ Metodos Abstratos ************************************************
	 * *******************************************************************************************************************
	 */

	public List<Aula> findAllByDisciplinaAndDay(Disciplina disciplina, Date day);

}
