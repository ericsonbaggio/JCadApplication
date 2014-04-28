package br.cad.web.system

import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.cad.util.MD5;

import br.cad.model.system.User;
import br.cad.service.system.UserService;

class LoginController {
	
	@ManagedProperty("#{userService}")
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	def autenticar() {
		
	}
	
	def entrar(){
		String keyUser = params.keyUser
		String password = params.password
	
		User user = keyUser ? userService.login(keyUser, password) : null
		//If login succeed
		if(user != null && user?.password.equalsIgnoreCase(MD5.encrypt(password))){
			session.user = user
			flash.message = "Login successful";
			redirect(action:'autenticar');
		}
		else{
			flash.message = "Usuário ou senha inválidos!";
			redirect(action:'autenticar');
		}
	}
}