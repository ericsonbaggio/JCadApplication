package br.cad.service.system.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;

import br.cad.dao.system.ActionDao;
import br.cad.model.system.Action;
import br.cad.model.system.User;
import br.cad.service.impl.AbstractService;
import br.cad.service.system.ActionService;

/**
 * 
 * @author Will
 * 
 */
@Service("actionService")
public class ActionServiceImpl extends AbstractService<Action, ActionDao> implements ActionService, Serializable {
	/**
	 * SerialVersion
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<Action> findAllUser(Long idUser) {
		return dao.findAllUser(idUser);
	}

	@Override
	public List<Action> findAllByResourceUser(String idUser, String idResource) {
		return dao.findAllByResourceAndUser(idUser, idResource);
	}

	@Override
	public List<Action> findAllByResource(Long idResource) {
		return dao.findAllByResourceAndUser(idResource);
	}

	@Override
	public List<Action> findAllByPageInUser(String page, User user) {
		return dao.findAllByPageInUser(page, user);
	}
}
