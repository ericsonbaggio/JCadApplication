package br.cad.service.academico;

import java.util.List;

import br.cad.model.academico.Nota;
import br.cad.model.pessoa.Aluno;
import br.cad.service.Service;

/**
 * 
 * @author WilliamRodrigues <br> {@link william.rodrigues@live.fae.edu}
 *
 */
public interface NotaService extends Service<Nota> {

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Metodos *****************************************************
	 * *******************************************************************************************************************
	 */

	public List<Nota> findAllNotasByAluno(Aluno aluno);
}
