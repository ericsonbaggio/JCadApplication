package br.cad.service.system;

import br.cad.model.system.User;
import br.cad.service.Service;

/**
 * 
 * @author Will
 *
 */
public interface UserService extends Service<User> {

	public User login(String user, String password);

}
