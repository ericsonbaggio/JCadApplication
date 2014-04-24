package br.cad.dao.system.hibernate;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.cad.dao.hibernate.AbstractDaoHibernate;
import br.cad.dao.system.ResourceDao;
import br.cad.model.system.Resource;
/**
 * Implementação do ResourceDao em Hibernate
 * 
 * @author Will
 * @since 1.0
 */
@Repository("resourceDao")
public class ResourceDaoHibernate extends AbstractDaoHibernate<Resource> implements ResourceDao {

	/* 
	 ******************************************************************************************************************
	 ************************************************** Construtor ****************************************************
	 ******************************************************************************************************************
	 */
	
	public ResourceDaoHibernate() {
		this.setEdPackageModel("br.cad.model.system.");
	}
	
	/*
	 ********************************************************************************************************************
	 ****************************************************** Metodos *****************************************************
	 ********************************************************************************************************************
	 */

	@Override
	@SuppressWarnings("unchecked")
	public List<Resource> findAllWithoutDomain() {
		return createCriteria(Resource.class).add(Restrictions.isNull("domain")).list();
	}
	
	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Resource> findAllUser(Long idUser) {
		return createQuery("SELECT DISTINCT r from Group g JOIN g.permissions p JOIN p.resource r JOIN g.users u WHERE u.id =:idUser order by r.name").setLong("idUser", idUser).list();
	}

	@Override
	public Resource findByPage(String page) {
		return (Resource) createQuery("SELECT DISTINCT r FROM Resource r INNER JOIN r.files page WHERE page.file=:page").setString("page", page).uniqueResult();
	}
}
