package br.cad.dao.academico.hibernate;

import org.springframework.stereotype.Repository;

import br.cad.dao.academico.ComentarioDao;
import br.cad.dao.hibernate.AbstractDaoHibernate;
import br.cad.model.academico.Comentario;

/**
 * Implementação do ComentarioDao em Hibernate
 * 
 * @author WilliamRodrigues <br>
 *         {@link william.rodrigues@live.fae.edu}
 * @since 1.0
 */
@Repository("comentarioDao")
public class ComentarioDaoHibernate extends AbstractDaoHibernate<Comentario> implements ComentarioDao {

	/*
	 * *****************************************************************************************************************
	 * ************************************************* Construtor ****************************************************
	 * *****************************************************************************************************************
	 */

	public ComentarioDaoHibernate() {
		this.setEdPackageModel(Comentario.class.getPackage().toString().substring(8) + ".");
	}

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Metodos *****************************************************
	 * *******************************************************************************************************************
	 */
}
