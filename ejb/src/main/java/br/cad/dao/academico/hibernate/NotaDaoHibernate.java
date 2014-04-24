package br.cad.dao.academico.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.cad.dao.academico.NotaDao;
import br.cad.dao.hibernate.AbstractDaoHibernate;
import br.cad.model.academico.Nota;
import br.cad.model.pessoa.Aluno;

/**
 * Implementação do NotaDao em Hibernate
 * 
 * @author WilliamRodrigues <br>
 *         {@link william.rodrigues@live.fae.edu}
 * @since 1.0
 */
@Repository("notaDao")
public class NotaDaoHibernate extends AbstractDaoHibernate<Nota> implements NotaDao {

	/*
	 * *****************************************************************************************************************
	 * ************************************************* Construtor ****************************************************
	 * *****************************************************************************************************************
	 */

	public NotaDaoHibernate() {
		this.setEdPackageModel(Nota.class.getPackage().toString().substring(8) + ".");
	}

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Metodos *****************************************************
	 * *******************************************************************************************************************
	 */

	@Override
	public List<Nota> findAllNotasByAluno(Aluno aluno) {
		return null;
	}
}
