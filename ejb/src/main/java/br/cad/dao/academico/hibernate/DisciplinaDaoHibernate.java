package br.cad.dao.academico.hibernate;

import org.springframework.stereotype.Repository;

import br.cad.dao.academico.DisciplinaDao;
import br.cad.dao.hibernate.AbstractDaoHibernate;
import br.cad.model.academico.Disciplina;

/**
 * Implementação do DisciplinaDao em Hibernate
 * 
 * @author WilliamRodrigues <br>
 *         {@link william.rodrigues@live.fae.edu}
 * @since 1.0
 */
@Repository("disciplinaDao")
public class DisciplinaDaoHibernate extends AbstractDaoHibernate<Disciplina> implements DisciplinaDao {

	/*
	 * *****************************************************************************************************************
	 * ************************************************* Construtor ****************************************************
	 * *****************************************************************************************************************
	 */

	public DisciplinaDaoHibernate() {
		this.setEdPackageModel(Disciplina.class.getPackage().toString().substring(8) + ".");
	}

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Metodos *****************************************************
	 * *******************************************************************************************************************
	 */
}
