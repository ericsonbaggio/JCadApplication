package br.cad.service.academico.impl;

import java.util.List;

import javax.faces.bean.ManagedProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.cad.dao.academico.NotaDao;
import br.cad.model.academico.Nota;
import br.cad.model.pessoa.Aluno;
import br.cad.service.academico.DisciplinaService;
import br.cad.service.academico.NotaService;
import br.cad.service.impl.AbstractService;
import br.cad.service.pessoa.AlunoService;

/**
 * 
 * @author WilliamRodrigues <br>
 *         {@link william.rodrigues@live.fae.edu}
 * 
 */
@Service("notaService")
public class NotaServiceImpl extends AbstractService<Nota, NotaDao> implements NotaService {

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Atributos****************************************************
	 * *******************************************************************************************************************
	 */

	@ManagedProperty("#{alunoService}")
	private AlunoService alunoService;
	@ManagedProperty("#{disciplinaService}")
	private DisciplinaService disciplinaService;

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** GETS E SETS *************************************************
	 * *******************************************************************************************************************
	 */

	public DisciplinaService getDisciplinaService() {
		return disciplinaService;
	}

	@Autowired
	public void setDisciplinaService(DisciplinaService disciplinaService) {
		this.disciplinaService = disciplinaService;
	}

	public AlunoService getAlunoService() {
		return alunoService;
	}

	@Autowired
	public void setAlunoService(AlunoService alunoService) {
		this.alunoService = alunoService;
	}

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Metodos *****************************************************
	 * *******************************************************************************************************************
	 */

	@Override
	public List<Nota> findAllNotasByAluno(Aluno aluno) {
		return dao.findAllNotasByAluno(aluno);
	}

}
