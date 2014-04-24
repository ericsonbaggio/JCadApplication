package br.cad.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.primefaces.context.RequestContext;

import com.ocpsoft.pretty.faces.servlet.PrettyFacesWrappedResponse;

import br.cad.util.Conf;
import br.cad.model.system.Action;
import br.cad.model.system.Domain;
import br.cad.model.system.Resource;
import br.cad.model.system.User;
import br.cad.service.system.ActionService;
import br.cad.service.system.DomainService;
import br.cad.service.system.ResourceService;

public abstract class AppController implements Serializable {
	/**
	 * SerialVersion
	 */
	private static final long serialVersionUID = 1L;
	public static Logger log = Logger.getLogger("LOG");

	/*
	 * *****************************************************************************************************************
	 * ************************************************** Atributos ****************************************************
	 * *****************************************************************************************************************
	 */

	/* ************************************************** SERVICES *************************************************** */
	@ManagedProperty("#{domainService}")
	protected DomainService domainService;
	@ManagedProperty("#{resourceService}")
	protected ResourceService resourceService;
	@ManagedProperty("#{actionService}")
	protected ActionService actionService;

	protected Long id;
	protected String param;
	protected String msg;
	protected String idURL;
	protected Resource resourceSelected;

	/*
	 * ******************************************************************************************************************
	 * **************************************************** Gets e Sets *************************************************
	 * ******************************************************************************************************************
	 */

	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}

	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	public void setActionService(ActionService actionService) {
		this.actionService = actionService;
	}

	protected Long getId() {
		return id;
	}

	protected void setId(Long id) {
		this.id = id;
	}

	protected String getParam() {
		return param;
	}

	protected void setParam(String param) {
		this.param = param;
	}

	protected String getMsg() {
		return msg;
	}

	protected void setMsg(String msg) {
		this.msg = msg;
	}

	protected String getIdURL() {
		return idURL;
	}

	protected void setIdURL(String idURL) {
		this.idURL = idURL;
	}

	public Resource getResourceSelected() {
		return resourceSelected;
	}

	public void setResourceSelected(Resource resourceSelected) {
		this.resourceSelected = resourceSelected;
	}

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Metodos *****************************************************
	 * *******************************************************************************************************************
	 */

	/**
	 * Retorna um map que representa as variaveis guardadas a sessao
	 * 
	 * @return Map<String, Object>
	 */
	protected Map<String, Object> getSession() {
		return FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	}

	/**
	 * Captura um map que representa os cookies
	 * 
	 * @return Cookie
	 */
	protected Map<String, Object> getCookies() {
		return FacesContext.getCurrentInstance().getExternalContext().getRequestCookieMap();
	}

	/**
	 * Capturar cookie pelo name
	 * 
	 * @return String
	 */
	public String getCookie(String nameCookie) {
		Cookie cookie = (Cookie) getCookies().get(nameCookie);

		return cookie == null ? null : cookie.getValue();
	}

	/**
	 * Captura o parametro por request da pagina
	 * 
	 * @param param
	 * @return String
	 */
	protected String getParam(String param) {
		return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(param);
	}

	/**
	 * Captura o Usuario logado na sessao
	 * 
	 * @return User
	 */
	protected User getUserLogged() {
		return (User) getSession().get("userLogged");
	}

	/**
	 * Captura os dominios do usuario logado
	 * 
	 * @return List<Domain>
	 */
	@SuppressWarnings("unchecked")
	public List<Domain> getDomainUser() {
		return (List<Domain>) getSession().get("domainUser");
	}

	/**
	 * Captura os recursos do usuario logado
	 * 
	 * @return List<Resource>
	 */
	@SuppressWarnings("unchecked")
	public List<Resource> getResourcesUser() {
		return (List<Resource>) getSession().get("resourcesUser");
	}

	/**
	 * Mensagens Informativa para Usuario
	 * 
	 * @param msg
	 */
	public void getMsgInfo(String msg) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null));
	}

	/**
	 * Mensagens de Erro para Usuario
	 * 
	 * @param msg
	 */
	public void getMsgError(String msg) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null));
	}

	/**
	 * Mensagens Fatal para Usuario
	 * 
	 * @param msg
	 */
	public void getMsgFatal(String msg) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, msg, null));
	}

	/**
	 * Mensagens de Atencao para Usuario
	 * 
	 * @param msg
	 */
	public void getMsgWarn(String msg) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, msg, null));
	}

	/**
	 * Acoes permitidas para o usuario
	 * 
	 * @return
	 */
	public List<Action> getActionsPageByUser() {
		if (resourceSelected != null) {
			return actionService.findAllByPageInUser(((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRequestURI()
					.substring(contexPath().length()), getUserLogged());
		}

		return null;
	}

	/**
	 * Retorna o objeto httpServletResponse, responsavel pela comunicacao com o cliente Traz informacoes do browser (ip, url acessado e etc)
	 */
	public HttpServletResponse getResponse() {
		return (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
	}

	public String contexPath() {
		Object ctx = FacesContext.getCurrentInstance().getExternalContext().getResponse();
		String contextPath = "";
		if (ctx instanceof PrettyFacesWrappedResponse) {
			contextPath = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getContextPath();
		} 
		else if (ctx instanceof HttpServletRequest) {
			contextPath = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getResponse()).getContextPath();
		}
		
		if (!contextPath.endsWith("/")) {
			contextPath = contextPath + "/";
		}

		return contextPath;
	}

	/**
	 * Redirecionar pagina
	 * 
	 * @param page
	 */
	public void getRedirect(String page) {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(page);
		} catch (IOException e) {
			e.printStackTrace();
			getMsgError(Conf.getProperty("msg.usernotpermission"));
		}
	}

	/**
	 * Executar script's
	 * 
	 * @param script
	 */
	public void getExecuteScript(String script) {
		RequestContext.getCurrentInstance().execute(script);
	}

	/**
	 * Captura componente pelo id
	 * 
	 * @param idComponent
	 * @return
	 */
	public UIComponent getFindComponent(String idComponent) {
		return FacesContext.getCurrentInstance().getViewRoot().findComponent(idComponent);
	}
	
	/**
	 * Atualizar componentes pelo id
	 * 
	 * @param component
	 */
	public void getRefreshViewComponent(String component) {
		// Using standard JSF API, add the client ID to PartialViewContext#getRenderIds()
		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add(component);

		// Using PrimeFaces specific API, use RequestContext#update().
		// RequestContext.getCurrentInstance().update(component);

		// Se acontecer de você usar JSF OmniFaces biblioteca utilitário, use Ajax # update ()
		// Ajax.update(component);
	}

	/**
	 * Salvar o cookie
	 * 
	 * @param nameCookie
	 * @param valueCookie
	 * @param expiry
	 *            = EX: (ss * mm * hh * dd) = 172800 = 2 Dias
	 * @param response
	 */
	public static void saveCookie(String nameCookie, String valueCookie, int expiry, HttpServletResponse response) {
		Cookie cookie = new Cookie(nameCookie, valueCookie);
		cookie.setPath("/");
		// cookie.setSecure(true);
		cookie.setMaxAge(expiry);
		response.addCookie(cookie);
	}

	/**
	 * Remove o cookie
	 * 
	 * @param nameCookie
	 * @param response
	 */
	public static void removeCookie(String nameCookie, HttpServletResponse response) {
		Cookie c = new Cookie(nameCookie, "");
		c.setMaxAge(0);
		c.setPath("/");
		response.addCookie(c);
	}

	/**
	 * Executar a expressao por meio do MethodExpression
	 * 
	 * @param expression
	 * @param paramsType
	 * @return
	 */
	protected MethodExpression createMethodExpression(String expression, Class<?>... paramsType) {
		FacesContext facesCtx = FacesContext.getCurrentInstance();
		ELContext elCtx = facesCtx.getELContext();
		ExpressionFactory expFact = facesCtx.getApplication().getExpressionFactory();

		return (MethodExpression) expFact.createMethodExpression(elCtx, expression, null, paramsType).invoke(elCtx, paramsType);
	}

	/**
	 * Executar action por meio de uma expressão
	 * 
	 * @param action
	 * @return
	 */
	@SuppressWarnings("el-syntax")
	public MethodExpression methodAction(Action action) {
		return createMethodExpression("#{" + getControllerBeanName(this) + "." + action.getMethod() + "}");
	}

	/**
	 * Pega o nome do controller definido na annotation ManagedBean
	 * 
	 * @param controller
	 * @return
	 */
	public static String getControllerBeanName(Object controller) {
		if (controller != null) {
			if (controller.getClass().isAnnotationPresent(ManagedBean.class)) {
				return controller.getClass().getAnnotation(ManagedBean.class).name();
			}
		}
		
		return null;
	}
	
	/**
	 * Listagem de todos os Dominios
	 * 
	 * @return
	 */
	public List<Domain> findAllDomain(){
		return domainService.findAllPropriety("subDominios", "is null");
	}
	
	/**
	 * Active no menu
	 * 
	 * @param idResource
	 * @param idDomain
	 * @return
	 */
	public String liActive(String idResource, String idDomain){
		if(resourceSelected != null) {
			if(StringUtils.isNotEmpty(idDomain) && StringUtils.isEmpty(idResource)) {
				List<Resource> recursos = resourceService.findAllPropriety("domain.id", idDomain);
				
				if(recursos != null && recursos.size() > 0  && idDomain.equals(resourceSelected.getDomain().getId().toString())) {
					return "active open";
				}
				else {
					for(Resource r : recursos) {
						if(r.getId().toString().equals(idResource)) {
							for(Domain d : r.getDomain().getSubDomains()) {
								if(d.getId().toString().equals(idDomain)) {
									return "active open";
								}
							}
						}
						else {
							return "";
						}
					}
				}
			}
			else if(resourceSelected != null && idResource.equals(resourceSelected.getId().toString())) {
				return "active";
			}
		}
		
		return "";
	}

	/**
	 * Captura o recurso pela pagina acessada
	 */
	protected void selectedResource() {
		this.resourceSelected = resourceService.findByPage(((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRequestURI().substring(contexPath().length()));
	}
}
