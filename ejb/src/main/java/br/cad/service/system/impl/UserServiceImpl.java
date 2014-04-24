package br.cad.service.system.impl;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import br.cad.dao.system.UserDao;
import br.cad.model.system.User;
import br.cad.service.impl.AbstractService;
import br.cad.service.system.UserService;

/**
 * 
 * @author Will
 * 
 */
@Service("userService")
public class UserServiceImpl extends AbstractService<User, UserDao> implements UserService, Serializable {
	/**
	 * SerialVersion
	 */
	private static final long serialVersionUID = 1L;

	public User login(String user, String password) {
		return dao.login(user, password);
	}
}
