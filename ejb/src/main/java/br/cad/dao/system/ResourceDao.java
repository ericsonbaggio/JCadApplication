package br.cad.dao.system;

import java.util.List;

import br.cad.dao.Dao;
import br.cad.model.system.Resource;

/**
 * Definição de Dao de Recurso
 * 
 * @author Will
 * @since 1.0
 */
public interface ResourceDao extends Dao<Resource> {
	
	/*
	 ********************************************************************************************************************
	 ************************************************* Metodos Abstratos ************************************************
	 ********************************************************************************************************************
	 */
	
	public List<Resource> findAllWithoutDomain();
	
	public List<Resource> findAllUser(Long idUser);

	public Resource findByPage(String page);
}
