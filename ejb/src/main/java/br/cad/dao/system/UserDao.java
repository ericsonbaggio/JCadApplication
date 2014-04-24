package br.cad.dao.system;

import br.cad.dao.Dao;
import br.cad.model.system.User;

/**
 * Definição de Dao de Usuário
 * 
 * @author Will
 * @since 1.0
 */
public interface UserDao extends Dao<User> {
	
	/*
	 ********************************************************************************************************************
	 ************************************************* Metodos Abstratos ************************************************
	 ********************************************************************************************************************
	 */
	
	/**
	 * Login do Usuario
	 * @param user
	 * @param password
	 * @return User
	 */
	public User login(String user, String password);
}
