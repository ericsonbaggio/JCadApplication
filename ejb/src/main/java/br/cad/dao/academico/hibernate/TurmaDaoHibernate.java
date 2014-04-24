package br.cad.dao.academico.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.cad.dao.academico.TurmaDao;
import br.cad.dao.hibernate.AbstractDaoHibernate;
import br.cad.model.academico.Turma;
import br.cad.model.system.User;

/**
 * Implementação do TurmaDao em Hibernate
 * 
 * @author WilliamRodrigues <br>
 *         {@link william.rodrigues@live.fae.edu}
 * @since 1.0
 */
@Repository("turmaDao")
public class TurmaDaoHibernate extends AbstractDaoHibernate<Turma> implements TurmaDao {

	/*
	 * *****************************************************************************************************************
	 * ************************************************* Construtor ****************************************************
	 * *****************************************************************************************************************
	 */

	public TurmaDaoHibernate() {
		this.setEdPackageModel("br.cad.model.academico.");
	}


	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Metodos *****************************************************
	 * *******************************************************************************************************************
	 */
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Turma> findTurmaByDocente(User user){
		return createQuery("SELECT t FROM Turma t INNER JOIN  t.docente d INNER JOIN d.usuario u WHERE u.id=:user").setLong("user", user.getId()).list();
	} 

}
