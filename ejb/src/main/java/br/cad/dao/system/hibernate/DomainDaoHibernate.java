package br.cad.dao.system.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.cad.dao.hibernate.AbstractDaoHibernate;
import br.cad.dao.system.DomainDao;
import br.cad.model.system.Domain;

/**
 * Implementação do DomionioDao em Hibernate
 * 
 * @author Will
 * @since 1.0
 */
@Repository("domainDao")
public class DomainDaoHibernate extends AbstractDaoHibernate<Domain> implements DomainDao {

	/*
	 * *****************************************************************************************************************
	 * ************************************************* Construtor ****************************************************
	 * *****************************************************************************************************************
	 */

	public DomainDaoHibernate() {
		this.setEdPackageModel("br.cad.model.system.");
		this.setOrderFindAll("orderObject");
	}

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Metodos *****************************************************
	 * *******************************************************************************************************************
	 */

	@Override
	public List<Domain> findAll() {
		clearSession();
		
		return super.findAll();
	}
	
	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Domain> findAllUser(Long idUserLogged) {
		return createQuery("SELECT DISTINCT d FROM Group g JOIN g.permissions p JOIN p.resource r JOIN r.domain d JOIN g.users u WHERE u.id =:idUser order by d.orderObject").setLong("idUser", idUserLogged).list();
	}
}
