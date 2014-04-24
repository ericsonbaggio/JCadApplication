package br.cad.dao.pessoa.hibernate;

import org.springframework.stereotype.Repository;

import br.cad.dao.pessoa.DocenteDao;
import br.cad.model.pessoa.Docente;

/**
 * Implementacao do DocenteDao em Hibernate
 * 
 * @author WilliamRodrigues <br> {@link william.rodrigues@live.fae.edu}
 * @since 1.0
 */
@Repository("docenteDao")
public class DocenteDaoHibernate extends PessoaPapelDaoHibernate<Docente> implements DocenteDao {

	/*
	 * *****************************************************************************************************************
	 * ************************************************* Construtor ****************************************************
	 * *****************************************************************************************************************
	 */

	public DocenteDaoHibernate() {
		this.setEdPackageModel("br.cad.model.pessoa.");
	}

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Metodos *****************************************************
	 * *******************************************************************************************************************
	 */
}
