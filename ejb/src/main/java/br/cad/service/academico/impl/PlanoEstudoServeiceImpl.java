package br.cad.service.academico.impl;

import javax.faces.bean.ManagedProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.cad.dao.academico.PlanoEstudoDao;
import br.cad.model.academico.PlanoEstudo;
import br.cad.service.academico.GradeService;
import br.cad.service.academico.PlanoEstudoService;
import br.cad.service.academico.TurmaService;
import br.cad.service.impl.AbstractService;

/**
 * 
 * @author WilliamRodrigues <br>
 *         {@link william.rodrigues@live.fae.edu}
 * 
 */
@Service("planoEstudoService")
public class PlanoEstudoServeiceImpl extends AbstractService<PlanoEstudo, PlanoEstudoDao> implements PlanoEstudoService {

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Atributos****************************************************
	 * *******************************************************************************************************************
	 */
	@ManagedProperty("#{gradeService}")
	private GradeService gradeService;
	@ManagedProperty("#{turmaService}")
	private TurmaService turmaService;

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** GETS E SETS *************************************************
	 * *******************************************************************************************************************
	 */

	public GradeService getGradeService() {
		return gradeService;
	}

	@Autowired
	public void setGradeService(GradeService gradeService) {
		this.gradeService = gradeService;
	}

	public TurmaService getTurmaService() {
		return turmaService;
	}

	@Autowired
	public void setTurmaService(TurmaService turmaService) {
		this.turmaService = turmaService;
	}

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Metodos *****************************************************
	 * *******************************************************************************************************************
	 */

}
