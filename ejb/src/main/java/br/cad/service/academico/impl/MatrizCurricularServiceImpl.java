package br.cad.service.academico.impl;

import javax.faces.bean.ManagedProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.cad.dao.academico.MatrizCurricularDao;
import br.cad.model.academico.MatrizCurricular;
import br.cad.service.academico.CursoService;
import br.cad.service.academico.MatrizCurricularService;
import br.cad.service.impl.AbstractService;

/**
 * 
 * @author WilliamRodrigues <br>
 *         {@link william.rodrigues@live.fae.edu}
 * 
 */
@Service("matrizCurricularService")
public class MatrizCurricularServiceImpl extends AbstractService<MatrizCurricular, MatrizCurricularDao> implements MatrizCurricularService {

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

}
