package br.cad.dao.system.hibernate;

import org.springframework.stereotype.Repository;

import br.cad.dao.hibernate.AbstractDaoHibernate;
import br.cad.dao.system.GroupDao;
import br.cad.model.system.Group;

/**
 * Implementação do GrupoDao em Hibernate
 * @author Will
 * @since 1.0
 */
@Repository("groupDao")
public class GroupDaoHibernate extends AbstractDaoHibernate<Group> implements GroupDao {
	
	/* 
	 ******************************************************************************************************************
	 ************************************************** Construtor ****************************************************
	 ******************************************************************************************************************
	 */
	
	public GroupDaoHibernate() {
		this.setEdPackageModel("br.cad.model.system.");
	}
	
	/*
	 ********************************************************************************************************************
	 ****************************************************** Metodos *****************************************************
	 ********************************************************************************************************************
	 */
}
