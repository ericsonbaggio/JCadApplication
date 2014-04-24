package br.cad.service.system;

import java.util.List;

import br.cad.model.system.Action;
import br.cad.model.system.User;
import br.cad.service.Service;

/**
 * 
 * @author Will
 *
 */
public interface ActionService extends Service<Action> {
	
	/*
	 ********************************************************************************************************************
	 ****************************************************** Metodos *****************************************************
	 ********************************************************************************************************************
	 */

	public List<Action> findAllUser(Long idUser);
	
	public List<Action> findAllByResourceUser(String idUser, String idResource);
	
	public List<Action> findAllByResource(Long idResource);

	public List<Action> findAllByPageInUser(String page, User user);
}
