package br.cad.dao.academico.hibernate;

import org.springframework.stereotype.Repository;

import br.cad.dao.academico.PlanoEstudoDao;
import br.cad.dao.hibernate.AbstractDaoHibernate;
import br.cad.model.academico.PlanoEstudo;

/**
 * Implementação do PlanoEstudoDao em Hibernate
 * 
 * @author WilliamRodrigues <br>
 *         {@link william.rodrigues@live.fae.edu}
 * @since 1.0
 */
@Repository("dlanoEstudoDao")
public class PlanoEstudoDaoHibernate extends AbstractDaoHibernate<PlanoEstudo> implements PlanoEstudoDao {

	/*
	 * *****************************************************************************************************************
	 * ************************************************* Construtor ****************************************************
	 * *****************************************************************************************************************
	 */

	public PlanoEstudoDaoHibernate() {
		this.setEdPackageModel("br.cad.model.academico.");
	}

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Metodos *****************************************************
	 * *******************************************************************************************************************
	 */

}
