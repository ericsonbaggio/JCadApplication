package br.cad.dao.pessoa;

import br.cad.dao.Dao;
import br.cad.model.pessoa.PessoaPapel;
import br.cad.model.system.User;

public interface PessoaPapelDao<PESSOA extends PessoaPapel> extends Dao<PESSOA>{

	/*
	 ********************************************************************************************************************
	 ************************************************* Metodos Abstratos ************************************************
	 ********************************************************************************************************************
	 */
	
	public PESSOA findByUsuario(User usuario);
	
	public Boolean disablePeople(PESSOA pessoa);
}
