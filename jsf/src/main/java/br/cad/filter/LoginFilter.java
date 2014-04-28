package br.cad.filter;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.cad.model.system.User;


public class LoginFilter implements Filter, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Logger log = Logger.getLogger(LoginFilter.class.getSimpleName());
	

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		if(precisaLogin((HttpServletRequest) request)) {
			
			//Verifica se esta logado
			HttpSession session = ((HttpServletRequest) request).getSession();
			
			//Captura o usuario na Sessao
			User user = (User) session.getAttribute("userLogged");
			
			if(user==null) {
				//Busca o local da pagina 
				String pagina = localPagina((HttpServletRequest) request) + "login";
				
				//Retorna a pagina para o usuario
				((HttpServletResponse) response).sendRedirect(pagina);
			}
			else{
				//Pega a pagina que esta sendo acessada
				String paginaAcessada = ((HttpServletRequest)request).getRequestURI();
				String contextPath = ((HttpServletRequest) request).getContextPath();
				if(!contextPath.endsWith("/")) {
					contextPath = contextPath + "/";
				}
				
				paginaAcessada = paginaAcessada.substring(contextPath.length());
				
				// Verifica se o usuario tem acesso a pagina
				//log.info(String.valueOf(user.isPermittedAccess(paginaAcessada)));
				if(user.isPermittedAccess(paginaAcessada) || paginaAcessada.equals("")) {
					//Faz o processamento da pagina
					chain.doFilter(request, response);
				}
				else {
					//Busca o local da pagina 
					String pagina = contextPath + "pages/notPermission";
					
					//Retorna a pagina para o usuario
					((HttpServletResponse) response).sendRedirect(pagina);
				}
			}
			
		}
		else {
			//Faz o processamento da pagina
			chain.doFilter(request, response);	
		}
		
	}

	/**
	 * @param request
	 * @return
	 */
	public String localPagina(HttpServletRequest request){
		String contextPath = ((HttpServletRequest) request).getContextPath();
		if(!contextPath.endsWith("/")) {
			contextPath = contextPath + "/";
		}
		
		return contextPath;
	}
	
	private boolean precisaLogin(HttpServletRequest request) {
		String paginaAcessada = request.getRequestURI();
		
		String contextPath = ((HttpServletRequest) request).getContextPath();

//		log.info(paginaAcessada);
		
		if (!contextPath.endsWith("/")) {
			contextPath = contextPath + "/";
		}
		
		if (paginaAcessada.startsWith(contextPath + "javax.faces.resource/")) {
			// Nao precisa de login
			return false;
		}
		
		if (paginaAcessada.equals(contextPath + "login")) {
			// Nao precisa de login
			return false;
		}
		
		if (paginaAcessada.equals(contextPath + "logout")) {
			// Nao precisa de login
			return false;
		}
		
		if (paginaAcessada.equals(contextPath + "loginExpired")) {
			// Nao precisa de login
			return false;
		}
		
		if (paginaAcessada.equals(contextPath + "expired")) {
			// Nao precisa de login
			return false;
		}
		
		if (paginaAcessada.startsWith(contextPath + "webservice")) {
			// Nao precisa de login
			return false;
		}
		
		if (paginaAcessada.startsWith(contextPath + "/")) {
			if (request.getSession().getAttribute("userLogged") == null)
				return true;
		}
		
		if (paginaAcessada.startsWith(contextPath + "assets/") || paginaAcessada.startsWith(contextPath + "icons/") 
				|| paginaAcessada.startsWith(contextPath + "imagens/") || paginaAcessada.startsWith(contextPath + "pages/")) {
			// Não precisa de login
			return false;
		}
		
		// Precisa de login
		return true;
	}
	
	public void init(FilterConfig config) throws ServletException {
	}

}
