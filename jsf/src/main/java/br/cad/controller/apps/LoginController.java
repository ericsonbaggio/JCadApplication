package br.cad.controller.apps;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.hibernate.validator.constraints.Email;

import br.cad.controller.AbstractCrudController;
import br.cad.model.system.Action;
import br.cad.model.system.Domain;
import br.cad.model.system.Resource;
import br.cad.model.system.User;
import br.cad.service.system.ActionService;
import br.cad.service.system.DomainService;
import br.cad.service.system.GroupService;
import br.cad.service.system.ResourceService;
import br.cad.service.system.UserService;
import br.cad.util.Conf;
import br.cad.util.VelocityParser;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

@ViewScoped
@ManagedBean(name = "loginController")
@URLMappings(mappings = { 
		@URLMapping(id = "login", pattern = "/login", viewId = "/apps/login.jsf"),
		@URLMapping(id = "login-user", pattern = "/login/#{loginController.keyUser}", viewId = "/apps/login.jsf"),
		@URLMapping(id = "logout", pattern = "/logout", viewId = "/apps/login.jsf?logout=true"),
		@URLMapping(id = "expired", pattern = "/expired", viewId = "/apps/login.jsf?expired=true"),
		@URLMapping(id = "login-expired", pattern = "/loginExpired", viewId = "/apps/login.jsf?session=true") })
public class LoginController extends AbstractCrudController<User, UserService> implements Serializable {
	/**
	 * SerialVersion
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * *****************************************************************************************************************
	 * ************************************************** Atributos ****************************************************
	 * *****************************************************************************************************************
	 */

	@ManagedProperty("#{domainService}")
	private DomainService domainService;
	@ManagedProperty("#{resourceService}")
	private ResourceService resourceService;
	@ManagedProperty("#{actionService}")
	private ActionService actionService;
	@ManagedProperty("#{groupService}")
	private GroupService groupService;
	@ManagedProperty("#{userService}")
	private UserService service;

	private User user;

	private String keyUser;
	private String password;
	private Boolean remember;

	// E-mail para resetar Senha do usuário
	private String email;

	/*
	 * ******************************************************************************************************************
	 * **************************************************** Gets e Sets *************************************************
	 * ******************************************************************************************************************
	 */
	@Override
	public void setService(UserService service) {
		this.service = super.service = service;
	}

	public void setDomainService(DomainService domainService) {
		this.domainService = super.domainService = domainService;
	}

	public void setResourceService(ResourceService resourceService) {
		this.resourceService = super.resourceService = resourceService;
	}

	public void setActionService(ActionService actionService) {
		this.actionService = super.actionService = actionService;
	}

	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getKeyUser() {
		return keyUser;
	}

	public void setKeyUser(String keyUser) {
		this.keyUser = keyUser;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getRemember() {
		return remember;
	}

	public void setRemember(Boolean remember) {
		this.remember = remember;
	}

	@Email(message = "Email não valido!!!")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean getSessionExpired() {
		if(StringUtils.isNotEmpty(getParam("session")) && getParam("session").equals("true")) {
			return true;
		}
		
		return false;
	}

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Metodos *****************************************************
	 * *******************************************************************************************************************
	 */

	/**
	 * Metodo iniciado na construcao da Classe
	 */
	@PostConstruct
	public void iniciar() {
		if(StringUtils.isNotEmpty(getParam("logout")) && getParam("logout").equals("true")) {
			this.logout();
		}
		
		if(StringUtils.isNotEmpty(getParam("expired")) && getParam("expired").equals("true")) {
			getRedirect(contexPath() + "loginExpired");
		}
		
		String userLoginCookie = getCookie("keyUser");

		if (StringUtils.isNotEmpty(userLoginCookie) == true) {
			//
			User usuarioCookie = new User();

			//
			usuarioCookie.setKeyUser(userLoginCookie);

			//
			if (usuarioCookie.checkValidKey(getCookie("userKey")) == true) {
				user = (User) getService().findByPropriety("keyUser", userLoginCookie);

				keyUser = user.getKeyUser();

				password = "*************";

				remember = true;
			}
		}
	}

	/**
	 * Metodo para se logar ou fazer login
	 * 
	 * @return pagina
	 */
	public void logar() {
		if (user == null || !password.equals("*************")) {
			user = getService().login(keyUser, password);
		}

		if (user == null) {
			this.getMsgError(Conf.getProperty("msg.userInvalid"));
		} 
		else if (!(user.getActive() == true)) {
			this.getMsgError(Conf.getProperty("msg.userNotActive"));
		} 
		else {
			List<Domain> domainUser = domainService.findAllUser(user.getId());
			// Add variavel de sessao getdomainUser
			getSession().put("domainUser", domainUser);

			List<Resource> resourceUser = resourceService.findAllUser(user.getId());
			// Add variavel de sessao getresourceUser
			getSession().put("resourcesUser", resourceUser);

			List<Action> actionUser = actionService.findAllUser(user.getId());
			// Add variavel de sessao getactionUser
			getSession().put("actionsUser", actionUser);

			// // Carrega os direitos do usuario
			// for (Group grupo : user.getGroups()) {
			// for (Permission permission : grupo.getPermissions()) {
			// log.info(permission.getResource().getName());
			// }
			// }

			getSession().put("userLogged", user);

			// Adicionar Cookie
			if (remember != null && remember == true) {
				saveCookie("keyUser", user.getKeyUser(), 172800, getResponse());
				saveCookie("userKey", user.getUserKey(), 172800, getResponse());
			}

			getRedirect(contexPath());
		}
	}

	@SuppressWarnings("deprecation")
	public void recuperarSenha() {
		User usuario = (User) getService().findByPropriety("edEmail", email);
		if (usuario != null) {
			// Reseta a Senha do usuario
			Date date = new Date();
			String senha = "C*" + date.getDay() + "A*" + date.getMonth() + "D*" + date.getYear();
			usuario.setPasswordKeyUser(senha);

			// Enviar E-mail
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("nome", usuario.getName());
			params.put("email", usuario.getEmail());
			params.put("username", usuario.getKeyUser());
			params.put("senha", senha);

			// Carrega o template indique_amigo_template.html substituindo as variaveis
			String mensagem = VelocityParser.loadTemplate("/apps/recuperarSenha.html", params);

			try {
				HtmlEmail emailSender = new HtmlEmail();

				// Setar o ip ou dns do servidor de e-mail
				emailSender.setHostName("mail.DOMINIO.com.br");

				emailSender.addTo(usuario.getEmail());
				emailSender.setFrom("e-mail", "Nome");
				emailSender.setSubject("Senha Recuperada");

				// Seta o texto da mensagem que veio do template
				emailSender.setHtmlMsg(mensagem);

				// Adicionando autenticacao no e-mail
				emailSender.setAuthentication("email@email", "_senha_");
				emailSender.setSmtpPort(587);
				emailSender.setSSLOnConnect(false);
				emailSender.setStartTLSEnabled(false);

				emailSender.send();

				getService().save(usuario);

				getMsgInfo("E-mail enviado com sucesso!");

				usuario = null;
			} catch (EmailException e) {
				getMsgError(e.getMessage());
			}
		} else {
			getMsgError(Conf.getProperty("msg.emailNotRegisteredUser"));
		}
	}
}