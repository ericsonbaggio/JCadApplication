package br.cad.dao.academico;

import java.util.List;

import br.cad.dao.Dao;
import br.cad.model.academico.Turma;
import br.cad.model.system.User;

/**
 * Definição de Dao da Turma
 * 
 * @author WilliamRodrigues <br>
 *         {@link william.rodrigues@live.fae.edu}
 * @since 1.0
 */
public interface TurmaDao extends Dao<Turma> {

	/*
	 * *******************************************************************************************************************
	 * ************************************************ Metodos Abstratos ************************************************
	 * *******************************************************************************************************************
	 */
	
	
	public List<Turma> findTurmaByDocente(User user);

}
