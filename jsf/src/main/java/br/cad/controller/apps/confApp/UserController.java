package br.cad.controller.apps.confApp;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.cad.controller.AbstractCrudController;
import br.cad.model.system.User;
import br.cad.service.system.UserService;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

/**
 * 
 * @author WilliamRodrigues
 *
 */
@ViewScoped
@ManagedBean(name = "userController")
@URLMappings(mappings = { 
		@URLMapping(id = "user-new", pattern = "/confApp/user/new", viewId = "/apps/confApp/user/new.jsf"),
		@URLMapping(id = "user-list", pattern = "/confApp/user/list", viewId = "/apps/confApp/user/list.jsf"),
		@URLMapping(id = "user-view", pattern = "/confApp/user/view/#{id}", viewId = "/apps/confApp/user/view.jsf"),
		@URLMapping(id = "user-edit", pattern = "/confApp/user/edit/#{id}", viewId = "/apps/confApp/user/edit.jsf") })
public class UserController extends AbstractCrudController<User, UserService> implements Serializable {
	/**
	 * SerialVersion
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * *****************************************************************************************************************
	 * ************************************************** Atributos ****************************************************
	 * *****************************************************************************************************************
	 */

	@ManagedProperty("#{userService}")
	private UserService service;

	/*
	 * *****************************************************************************************************************
	 * ************************************************ Gets e Sets ****************************************************
	 * *****************************************************************************************************************
	 */
	@Override
	public void setService(UserService service) {
		this.service = super.service = service;
	}
	
	/*
	 * *****************************************************************************************************************
	 * ************************************************** Metodos ******************************************************
	 * *****************************************************************************************************************
	 */

	@PostConstruct
	public void init() {
		this.setColumnsTemplate("{name Nome}, {keyUser Login}, {email E-mail}");
		
		this.load();
	}
}
