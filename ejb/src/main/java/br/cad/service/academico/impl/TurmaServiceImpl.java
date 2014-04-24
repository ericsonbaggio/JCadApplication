package br.cad.service.academico.impl;

import java.util.List;

import javax.faces.bean.ManagedProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.cad.dao.academico.TurmaDao;
import br.cad.model.academico.Turma;
import br.cad.model.system.User;
import br.cad.service.academico.DisciplinaService;
import br.cad.service.academico.TurmaService;
import br.cad.service.impl.AbstractService;
import br.cad.service.pessoa.AlunoService;

/**
 * 
 * @author WilliamRodrigues <br>
 *         {@link william.rodrigues@live.fae.edu}
 * 
 */
@Service("turmaService")
public class TurmaServiceImpl extends AbstractService<Turma, TurmaDao> implements TurmaService {

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

	public AlunoService getAlunoService() {
		return alunoService;
	}

	@Autowired
	public void setAlunoService(AlunoService alunoService) {
		this.alunoService = alunoService;
	}

	public DisciplinaService getDisciplinaService() {
		return disciplinaService;
	}

	@Autowired
	public void setDisciplinaService(DisciplinaService disciplinaService) {
		this.disciplinaService = disciplinaService;
	}

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Metodos *****************************************************
	 * *******************************************************************************************************************
	 */
	
	
	public List<Turma> findTurmaByDocente(User user){
		return dao.findTurmaByDocente(user);
	} 
}
