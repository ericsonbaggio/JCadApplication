package br.cad.service.academico.impl;

import javax.faces.bean.ManagedProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.cad.dao.academico.ComentarioDao;
import br.cad.model.academico.Comentario;
import br.cad.service.academico.AulaService;
import br.cad.service.academico.ComentarioService;
import br.cad.service.impl.AbstractService;

/**
 * 
 * @author WilliamRodrigues <br>
 *         {@link william.rodrigues@live.fae.edu}
 * 
 */
@Service("comentarioService")
public class ComentarioServiceImpl extends AbstractService<Comentario, ComentarioDao> implements ComentarioService {

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Atributos****************************************************
	 * *******************************************************************************************************************
	 */

	@ManagedProperty("#{aulaService}")
	private AulaService aulaService;

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** GETS E SETS *************************************************
	 * *******************************************************************************************************************
	 */

	public AulaService getAulaService() {
		return aulaService;
	}

	@Autowired
	public void setAulaService(AulaService aulaService) {
		this.aulaService = aulaService;
	}
	
	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Metodos *****************************************************
	 * *******************************************************************************************************************
	 */
}
