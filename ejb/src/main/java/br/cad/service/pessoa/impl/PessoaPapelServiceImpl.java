package br.cad.service.pessoa.impl;

import javax.faces.bean.ManagedProperty;

import org.springframework.beans.factory.annotation.Autowired;

import br.cad.dao.pessoa.PessoaPapelDao;
import br.cad.model.pessoa.PessoaPapel;
import br.cad.service.impl.AbstractService;
import br.cad.service.pessoa.PessoaPapelService;
import br.cad.service.system.UserService;

/** 
 * 
 * @author WilliamRodrigues <br> {@link william.rodrigues@live.fae.edu}
 *
 * @param <PESSOA>
 * @param <PESSOADAO>
 */
public class PessoaPapelServiceImpl<PESSOA extends PessoaPapel, PESSOADAO extends PessoaPapelDao<PESSOA>> extends AbstractService<PESSOA, PESSOADAO> implements PessoaPapelService<PESSOA> {

	private PESSOADAO dao;
	
	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Atributos****************************************************
	 * *******************************************************************************************************************
	 */

	@ManagedProperty("#{usuarioService}")
	private UserService usuarioService;	
	
	/*
	 * *******************************************************************************************************************
	 * ***************************************************** GETS E SETS *************************************************
	 * *******************************************************************************************************************
	 */

	public UserService getUsuarioService() {
		return usuarioService;
	}

	@Autowired
	public void setUsuarioService(UserService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	public PESSOADAO getDao() {
		return this.dao = super.dao;
	}

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Metodos *****************************************************
	 * *******************************************************************************************************************
	 */

	@Override
	public PESSOA login(String usuario, String senha) {
		return null;
	}

	@Override
	public Boolean disablePeople(PESSOA pessoa) {
		return dao.disablePeople(pessoa);
	}

	@Override
	public PESSOA save(PESSOA model) {
		model.getUsuario().setActive(model.getSitPessoa());
		
		return super.save(model);
	}
}
