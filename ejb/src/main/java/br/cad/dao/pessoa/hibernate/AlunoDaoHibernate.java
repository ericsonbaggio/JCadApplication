package br.cad.dao.pessoa.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.cad.dao.pessoa.AlunoDao;
import br.cad.model.academico.Turma;
import br.cad.model.pessoa.Aluno;

/**
 * Implementação do AlunoDao em Hibernate
 * 
 * @author WilliamRodrigues <br> {@link william.rodrigues@live.fae.edu}
 * @since 1.0
 */
@Repository("alunoDao")
public class AlunoDaoHibernate extends PessoaPapelDaoHibernate<Aluno> implements AlunoDao {

	/*
	 * *****************************************************************************************************************
	 * ************************************************* Construtor ****************************************************
	 * *****************************************************************************************************************
	 */

	public AlunoDaoHibernate() {
		this.setEdPackageModel("br.cad.model.pessoa.");
	}

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Metodos *****************************************************
	 * *******************************************************************************************************************
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Aluno> findAlunoByTurma(Turma turma){
		return createQuery("SELECT a FROM Turma t INNER JOIN t.alunos a WHERE t.id=:turma").setLong("turma", turma.getId()).list();
	}
}
