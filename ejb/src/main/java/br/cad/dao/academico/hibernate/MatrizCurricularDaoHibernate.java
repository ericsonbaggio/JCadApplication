package br.cad.dao.academico.hibernate;

import org.springframework.stereotype.Repository;

import br.cad.dao.academico.MatrizCurricularDao;
import br.cad.dao.hibernate.AbstractDaoHibernate;
import br.cad.model.academico.MatrizCurricular;

/**
 * Implementação do MatrizCurricularDao em Hibernate
 * 
 * @author WilliamRodrigues <br>
 *         {@link william.rodrigues@live.fae.edu}
 * @since 1.0
 */
@Repository("matrizCurricularDao")
public class MatrizCurricularDaoHibernate extends AbstractDaoHibernate<MatrizCurricular> implements MatrizCurricularDao {

	/*
	 * *****************************************************************************************************************
	 * ************************************************* Construtor ****************************************************
	 * *****************************************************************************************************************
	 */

	public MatrizCurricularDaoHibernate() {
		this.setEdPackageModel(MatrizCurricular.class.getPackage().toString().substring(8) + ".");
	}

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Metodos *****************************************************
	 * *******************************************************************************************************************
	 */

}
