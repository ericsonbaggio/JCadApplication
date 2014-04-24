package br.cad.dao.system.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.cad.dao.hibernate.AbstractDaoHibernate;
import br.cad.dao.system.ActionDao;
import br.cad.model.system.Action;
import br.cad.model.system.ActionParameters;
import br.cad.model.system.User;

/**
 * Implementação do ActionDao em Hibernate
 * 
 * @author Will
 * @since 1.0
 */
@Repository("actionDao")
public class ActionDaoHibernate extends AbstractDaoHibernate<Action> implements ActionDao {

	/*
	 * *****************************************************************************************************************
	 * ************************************************* Construtor ****************************************************
	 * *****************************************************************************************************************
	 */

	public ActionDaoHibernate() {
		this.setEdPackageModel("br.cad.model.system.");
	}

	/*
	 * *****************************************************************************************************************
	 * ***************************************************** Metodos ***************************************************
	 * *****************************************************************************************************************
	 */
	
	@Override
	@SuppressWarnings("unchecked")
	public Action findById(Long id) {
		Action action = super.findById(id);
		
		if(action != null && action.getId() != null) {
			List<ActionParameters> actParams = createQuery("FROM ActionParameters WHERE action =:act").setLong("act", action.getId()).list();
			
			action.setParams(actParams == null ? new ArrayList<ActionParameters>() : actParams);
		}
		
		return action;
	}

	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Action> findAllUser(Long idUserLogged) {
		return createQuery("Select DISTINCT a from Group g JOIN g.permissions p JOIN p.action a JOIN g.users u WHERE u.id =:idUser order by a.name").setLong("idUser", idUserLogged).list();
	}

	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Action> findAllByResourceAndUser(String idUsuarioLogado, String idResource) {
		return (List<Action>) createQuery("Select DISTINCT a from Grupo g JOIN g.acoes a JOIN g.usuarios u INNER JOIN a.recursos r WHERE u.id =:user AND r.id =:resource order by a.nmAcao")
				.setString("user", idUsuarioLogado).setString("resource", idResource).list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Action> findAllByResourceAndUser(Long idResource) {
		return createQuery("SELECT a FROM Action a INNER JOIN a.resources r WHERE r.id in (:idResource)").setLong("idResource", idResource).list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Action> findAllByPageInUser(String page, User user) {
		return createQuery("SELECT DISTINCT a FROM Group g INNER JOIN g.permissions p INNER JOIN p.resource r INNER JOIN r.files rf INNER JOIN rf.actionsOfPages a INNER JOIN g.users u WHERE rf.file =:resourceFile AND u.id =:user").setString("resourceFile", page).setLong("user", user.getId()).list();
	}
}