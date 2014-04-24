package br.cad.dao.academico.hibernate;

import org.springframework.stereotype.Repository;

import br.cad.dao.academico.CursoDao;
import br.cad.dao.hibernate.AbstractDaoHibernate;
import br.cad.model.academico.Curso;

/**
 * Implementação do CursoDao em Hibernate
 * 
 * @author WilliamRodrigues <br>
 *         {@link william.rodrigues@live.fae.edu}
 * @since 1.0
 */
@Repository("cursoDao")
public class CursoDaoHibernate extends AbstractDaoHibernate<Curso> implements CursoDao {

	/*
	 * *****************************************************************************************************************
	 * ************************************************* Construtor ****************************************************
	 * *****************************************************************************************************************
	 */

	public CursoDaoHibernate() {
		this.setEdPackageModel(Curso.class.getPackage().toString().substring(8) + ".");
	}

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Metodos *****************************************************
	 * *******************************************************************************************************************
	 */

}
