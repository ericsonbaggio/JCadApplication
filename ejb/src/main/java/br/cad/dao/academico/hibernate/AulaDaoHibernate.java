package br.cad.dao.academico.hibernate;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.cad.dao.academico.AulaDao;
import br.cad.dao.hibernate.AbstractDaoHibernate;
import br.cad.model.academico.Aula;
import br.cad.model.academico.Disciplina;

/**
 * Implementação do AulaDao em Hibernate
 * 
 * @author WilliamRodrigues <br>
 *         {@link william.rodrigues@live.fae.edu}
 * @since 1.0
 */
@Repository("aulaDao")
public class AulaDaoHibernate extends AbstractDaoHibernate<Aula> implements AulaDao {

	/*
	 * *****************************************************************************************************************
	 * ************************************************* Construtor ****************************************************
	 * *****************************************************************************************************************
	 */

	public AulaDaoHibernate() {
		this.setEdPackageModel(Aula.class.getPackage().toString().substring(8) + ".");
	}

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Metodos *****************************************************
	 * *******************************************************************************************************************
	 */

	@Override
	public List<Aula> findAllByDisciplinaAndDay(Disciplina disciplina, Date day) {
		// TODO Auto-generated method stub
		return null;
	}
}
