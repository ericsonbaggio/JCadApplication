package br.cad.dao.system;

import java.util.List;

import br.cad.dao.Dao;
import br.cad.model.system.Domain;

/**
 * Definição de Dao de Dominio
 * 
 * @author WilliamRodrigues <br> {@link william.rodrigues@live.fae.edu}
 * @since 1.0
 */
public interface DomainDao extends Dao<Domain> {

	/*
	 ********************************************************************************************************************
	 ************************************************* Metodos Abstratos ************************************************
	 ********************************************************************************************************************
	 */
	
	public List<Domain> findAllUser(Long idUsuarioLogado);
}
