package br.cad.service.pessoa.impl;

import java.util.List;

import javax.faces.bean.ManagedProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.cad.dao.pessoa.AlunoDao;
import br.cad.model.academico.Turma;
import br.cad.model.pessoa.Aluno;
import br.cad.service.academico.CursoService;
import br.cad.service.pessoa.AlunoService;

/**
 * 
 * @author WilliamRodrigues
 * 
 */
@Service("alunoService")
public class AlunoServiceImpl extends PessoaPapelServiceImpl<Aluno, AlunoDao> implements AlunoService {

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Atributos****************************************************
	 * *******************************************************************************************************************
	 */

	@ManagedProperty("#{cursoService}")
	private CursoService cursoService;

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** GETS E SETS *************************************************
	 * *******************************************************************************************************************
	 */

	public CursoService getCursoService() {
		return cursoService;
	}

	@Autowired
	public void setCursoService(CursoService cursoService) {
		this.cursoService = cursoService;
	}
	
	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Metodos *****************************************************
	 * *******************************************************************************************************************
	 */
	
	@Override
	public List<Aluno> findAlunoByTurma(Turma turma) {
		return getDao().findAlunoByTurma(turma);
	}
}
