package br.cad.service.academico;

import java.util.Date;
import java.util.List;

import br.cad.model.academico.Aula;
import br.cad.model.academico.Disciplina;
import br.cad.service.Service;

/**
 * 
 * @author WilliamRodrigues <br> {@link william.rodrigues@live.fae.edu}
 *
 */
public interface AulaService extends Service<Aula> {

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Metodos *****************************************************
	 * *******************************************************************************************************************
	 */

	public List<Aula> findAllByDisciplinaAndDay(Disciplina disciplina, Date date);
}
