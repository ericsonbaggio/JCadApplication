package br.cad.service.academico;

import java.util.Date;
import java.util.List;

import br.cad.model.academico.Chamada;
import br.cad.model.academico.Disciplina;
import br.cad.model.pessoa.Aluno;
import br.cad.service.Service;

/**
 * 
 * @author WilliamRodrigues <br> {@link william.rodrigues@live.fae.edu}
 *
 */
public interface ChamadaService extends Service<Chamada> {

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Metodos *****************************************************
	 * *******************************************************************************************************************
	 */

	public List<Chamada> findAulas(Disciplina disciplina, Date day);
	
	public List<Chamada> findAllChamadasByAluno(Aluno aluno);
}
