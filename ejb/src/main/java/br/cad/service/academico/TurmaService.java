package br.cad.service.academico;

import java.util.List;

import br.cad.model.academico.Turma;
import br.cad.model.system.User;
import br.cad.service.Service;

/**
 * 
 * @author WilliamRodrigues <br> {@link william.rodrigues@live.fae.edu}
 *
 */
public interface TurmaService extends Service<Turma> {

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Metodos *****************************************************
	 * *******************************************************************************************************************
	 */

	public List<Turma> findTurmaByDocente(User user);
	
}
