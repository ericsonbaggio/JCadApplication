package br.cad.dao.hibernate;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 
 * @author WilliamRodrigues <br> {@link william.rodrigues@live.fae.edu}
 *
 */
@SuppressWarnings("deprecation")
public class HibernateUtil {
	private static SessionFactory sessionFactory;

	private static void createSessionFactory() {
		ServletContext context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();

		WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(context);

		sessionFactory = (SessionFactory) wac.getBean("sessionFactory");
	}

	/**
	 * Cria o hibernate para os testes
	 */
	public static void createSessionFactoryForTests() {
		if (sessionFactory == null)
			sessionFactory = new AnnotationConfiguration().configure("hibernate.cfg.teste.xml").buildSessionFactory();
	}

	public static Session getSession() {
		return getSessionFactory().getCurrentSession();
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			createSessionFactory();
		}
		return sessionFactory;
	}

}
