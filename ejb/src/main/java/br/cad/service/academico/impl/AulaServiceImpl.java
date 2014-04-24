package br.cad.service.academico.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import br.cad.dao.academico.AulaDao;
import br.cad.model.academico.Aula;
import br.cad.model.academico.Disciplina;
import br.cad.service.academico.AulaService;
import br.cad.service.impl.AbstractService;

/**
 * 
 * @author WilliamRodrigues <br>
 *         {@link william.rodrigues@live.fae.edu}
 * 
 */
@Service("aulaService")
public class AulaServiceImpl extends AbstractService<Aula, AulaDao> implements AulaService {

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Atributos****************************************************
	 * *******************************************************************************************************************
	 */

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** GETS E SETS *************************************************
	 * *******************************************************************************************************************
	 */

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Metodos *****************************************************
	 * *******************************************************************************************************************
	 */

	@Override
	public List<Aula> findAllByDisciplinaAndDay(Disciplina disciplina, Date day) {
		return dao.findAllByDisciplinaAndDay(disciplina, day);
	}
}
