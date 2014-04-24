package br.cad.dao.academico.hibernate;

import org.springframework.stereotype.Repository;

import br.cad.dao.academico.GradeDao;
import br.cad.dao.hibernate.AbstractDaoHibernate;
import br.cad.model.academico.Grade;

/**
 * Implementação do GradeDao em Hibernate
 * 
 * @author WilliamRodrigues <br>
 *         {@link william.rodrigues@live.fae.edu}
 * @since 1.0
 */
@Repository("gradeDao")
public class GradeDaoHibernate extends AbstractDaoHibernate<Grade> implements GradeDao {

	/*
	 * *****************************************************************************************************************
	 * ************************************************* Construtor ****************************************************
	 * *****************************************************************************************************************
	 */

	public GradeDaoHibernate() {
		this.setEdPackageModel("br.cad.model.academico.");
	}

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Metodos *****************************************************
	 * *******************************************************************************************************************
	 */

}
