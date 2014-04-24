package br.cad.dao.system.hibernate;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.cad.dao.hibernate.AbstractDaoHibernate;
import br.cad.dao.system.UserDao;
import br.cad.model.system.User;
import br.cad.util.MD5;

/**
 * Implementacao do UsuarioDao em Hibernate
 * 
 * @author Will
 * @since 1.0
 */
@Repository("userDao")
public class UserDaoHibernate extends AbstractDaoHibernate<User> implements UserDao {
	
	/* 
	 ******************************************************************************************************************
	 ************************************************** Construtor ****************************************************
	 ******************************************************************************************************************
	 */
	
	public UserDaoHibernate() {
		this.setEdPackageModel("br.cad.model.system.");
	}
	
	/*
	 ********************************************************************************************************************
	 ****************************************************** Metodos *****************************************************
	 ********************************************************************************************************************
	 */
	@Transactional
	@Override
	public User login(String keyUser, String password) {
		// Cria a consulta de Usuario por id
		Query query = createQuery("from User where keyUser=:keyUser and password=:password");
		// Seta o parametro id
		query.setString("keyUser", keyUser);
		try {
			query.setString("password", MD5.encrypt(password));
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Executa a consulta retornando um resultado apenas
		return (User) query.uniqueResult();
	}
}
