import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.FilterConfig
import javax.servlet.ServletException
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpSession

import br.cad.model.system.User

class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		if(precisaLogin((HttpServletRequest) request)) {

			//Verifica se esta logado
			HttpSession session = ((HttpServletRequest) request).getSession();

			//Cria o usuario na Sessao
			User usuario = (User) session.getAttribute("usuarioLogado");
			if(usuario==null) {
				//Busca o local da pagina
				String pagina = localPagina(request) + "login/autenticar";
				//Retorna a pagina para o usuario
				((HttpServletResponse) response).sendRedirect(pagina);
			}
			else{
				//Pega a pagina que esta sendo acessada
				String paginaAcessada = ((HttpServletRequest) request).getRequestURI();
				String contextPath = ((HttpServletRequest) request).getContextPath();
				if(!contextPath.endsWith("/")) {
					contextPath = contextPath + "/";
				}
				paginaAcessada = paginaAcessada.substring(contextPath.length());


				//Verifica se o usuario tem acesso a pagina
				//System.out.println(usuario.isTemAcesso(paginaAcessada));
				if(usuario.isTemAcesso(paginaAcessada) == false){
					//Busca o local da pagina
					String pagina = contextPath + "login/autenticar";

					//Retorna a pagina para o usuario
					((HttpServletResponse) response).sendRedirect(pagina);
				}

				//Faz o processamento da pagina
				chain.doFilter(request, response);
			}

		}else{

			//Faz o processamento da pagina
			chain.doFilter(request, response);
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	private boolean precisaLogin(HttpServletRequest request) {
		String paginaAcessada = request.getRequestURI();

		String contextPath = ((HttpServletRequest) request).getContextPath();
//		println paginaAcessada;

		if(!contextPath.endsWith("/")) {
			contextPath = contextPath + "/";
		}

		if(paginaAcessada.equals(contextPath)) {
			//Precisa de login
			return true;
		}

		if(paginaAcessada.equals(contextPath + "login/autenticar")) {
			//Nao Precisa de login
			return false;
		}
		
		if(paginaAcessada.equals(contextPath + "login/entrar")) {
			//Nao Precisa de login
			return false;
		}

		//Precisa de login
		return true;
	}

	/**
	 * Localiza em qual local foi acessado pelo usuario e retorna para a raiz.
	 * Assim e so adicionar a pagina a partir do raiz.
	 * @param request
	 * @return
	 */
	public String localPagina(HttpServletRequest request){
		String paginaAcessada = request.getRequestURI();

		String contextPath = ((HttpServletRequest) request).getContextPath();
		if(!contextPath.endsWith("/")) {
			contextPath = contextPath + "/";
		}

		paginaAcessada = paginaAcessada.substring(contextPath.length());
		int n = 0;
		for(int i = 0; i != -1;){
			i = paginaAcessada.indexOf("/");
			if(i != -1){
				i = i + 1;
				paginaAcessada = paginaAcessada.substring(i);
				n = n + 1;
			}
		}
		String local = "";
		for(int i = 0; i < n && n > 0; i++){
			local = "../" + local;
		}
		return local ;
	}
}