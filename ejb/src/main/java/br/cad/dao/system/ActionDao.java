package br.cad.dao.system;

import java.util.List;

import br.cad.dao.Dao;
import br.cad.model.system.Action;
import br.cad.model.system.User;

/**
 * Definição de Dao da Ação
 * 
 * @author WilliamRodrigues <br> {@link william.rodrigues@live.fae.edu}
 * @since 1.0
 */
public interface ActionDao extends Dao<Action> {
	
	/*
	 ********************************************************************************************************************
	 ************************************************* Metodos Abstratos ************************************************
	 ********************************************************************************************************************
	 */
	
	public List<Action> findAllUser(Long idUsuarioLogado);
	
	public List<Action> findAllByResourceAndUser(String idUsuarioLogado, String idResource);

	public List<Action> findAllByResourceAndUser(Long idResource);

	public List<Action> findAllByPageInUser(String page, User user);
}
