package br.cad.service.pessoa;

import br.cad.model.pessoa.PessoaPapel;
import br.cad.service.Service;

public interface PessoaPapelService<PESSOA extends PessoaPapel> extends Service<PESSOA>{
	
	/*
	 ********************************************************************************************************************
	 ****************************************************** Metodos *****************************************************
	 ********************************************************************************************************************
	 */
	
	public PESSOA login(String usuario, String senha);
	
	public Boolean disablePeople(PESSOA pessoa);
}
