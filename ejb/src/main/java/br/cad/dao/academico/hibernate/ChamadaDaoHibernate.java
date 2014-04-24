package br.cad.dao.academico.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.cad.dao.academico.ChamadaDao;
import br.cad.dao.hibernate.AbstractDaoHibernate;
import br.cad.model.academico.Chamada;
import br.cad.model.pessoa.Aluno;

/**
 * Implementação do ChamadaDao em Hibernate
 * 
 * @author WilliamRodrigues <br>
 *         {@link william.rodrigues@live.fae.edu}
 * @since 1.0
 */
@Repository("chamadaDao")
public class ChamadaDaoHibernate extends AbstractDaoHibernate<Chamada> implements ChamadaDao {

	/*
	 * *****************************************************************************************************************
	 * ************************************************* Construtor ****************************************************
	 * *****************************************************************************************************************
	 */

	public ChamadaDaoHibernate() {
		this.setEdPackageModel(Chamada.class.getPackage().toString().substring(8) + ".");
	}

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Metodos *****************************************************
	 * *******************************************************************************************************************
	 */

	@Override
	public List<Chamada> findAllChamadasByAluno(Aluno aluno) {
		// TODO Auto-generated method stub
		return null;
	}
}
