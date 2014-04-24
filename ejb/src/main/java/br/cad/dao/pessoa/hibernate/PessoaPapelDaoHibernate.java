package br.cad.dao.pessoa.hibernate;

import org.springframework.stereotype.Repository;

import br.cad.dao.hibernate.AbstractDaoHibernate;
import br.cad.dao.pessoa.PessoaPapelDao;
import br.cad.model.pessoa.PessoaPapel;
import br.cad.model.system.User;

/**
 * Implementacao do PessoaPapelDao em Hibernate
 * 
 * @author WilliamRodrigues <br> {@link william.rodrigues@live.fae.edu}
 * @since 1.0
 */
@Repository("pessoaPapelDao")
public class PessoaPapelDaoHibernate<PESSOA extends PessoaPapel> extends AbstractDaoHibernate<PESSOA> implements PessoaPapelDao<PESSOA> {

	/*
	 * *****************************************************************************************************************
	 * ************************************************* Construtor ****************************************************
	 * *****************************************************************************************************************
	 */

	public PessoaPapelDaoHibernate() {
		this.setEdPackageModel("br.cad.model.pessoa.");
	}

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Metodos *****************************************************
	 * *******************************************************************************************************************
	 */

	@Override
	public PESSOA findByUsuario(User usuario) {
		return null;
	}

	@Override
	public Boolean disablePeople(PESSOA pessoa) {
		return null;
	}
}
