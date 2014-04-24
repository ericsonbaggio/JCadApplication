package br.cad.service.academico.impl;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.cad.dao.academico.ChamadaDao;
import br.cad.model.academico.Chamada;
import br.cad.model.academico.Disciplina;
import br.cad.model.pessoa.Aluno;
import br.cad.service.academico.AulaService;
import br.cad.service.academico.ChamadaService;
import br.cad.service.impl.AbstractService;

/**
 * 
 * @author WilliamRodrigues <br>
 *         {@link william.rodrigues@live.fae.edu}
 * 
 */
@Service("chamadaService")
public class ChamadaServiceImpl extends AbstractService<Chamada, ChamadaDao> implements ChamadaService {

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

	@Override
	public List<Chamada> findAulas(Disciplina disciplina, Date day) {
		return null;
	}

	@Override
	public List<Chamada> findAllChamadasByAluno(Aluno aluno) {
		return dao.findAllChamadasByAluno(aluno);
	}
}
