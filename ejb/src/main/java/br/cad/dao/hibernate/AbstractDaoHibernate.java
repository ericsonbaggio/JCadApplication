package br.cad.dao.hibernate;

import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import br.cad.dao.Dao;
import br.cad.model.Model;
import br.cad.util.Conf;

/**
 * 
 * @author WilliamRodrigues <br>
 *         {@link william.rodrigues@live.fae.edu}
 * 
 * @param <MODEL>
 */
public abstract class AbstractDaoHibernate<MODEL extends Model> implements Dao<MODEL> {

	public static Logger log;
	
	/*
	 * *****************************************************************************************************************
	 * ************************************************** Atributos ****************************************************
	 * *****************************************************************************************************************
	 */
	
	protected String modelClassName;
	protected String edPackageModel;
	protected String orderFindAll;
	private SessionFactory sessionFactory;
	private Session session;

	/*
	 * ******************************************************************************************************************
	 * **************************************************** Gets e Sets *************************************************
	 * ******************************************************************************************************************
	 */
	
	public String getModelClassName() {
		String classname = this.getClass().getSimpleName();
		if (classname.endsWith("DaoHibernate")) {
			return classname.substring(0, classname.length() - 12);
		}
		return null;
	}

	public void setModelClassName(String modelClassName) {
		this.modelClassName = modelClassName;
	}

	public String getEdPackageModel() {
		return edPackageModel;
	}

	public void setEdPackageModel(String edPackageModel) {
		this.edPackageModel = edPackageModel;
	}

	public String getOrderFindAll() {
		return orderFindAll;
	}

	public void setOrderFindAll(String orderFindAll) {
		this.orderFindAll = orderFindAll;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		
		if(session == null)
			session = sessionFactory.openSession();
		else
			session = sessionFactory.getCurrentSession();
	}

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Metodos *****************************************************
	 * *******************************************************************************************************************
	 */
	
	/**
	 * 
	 * @param query
	 * @return
	 */
	protected Query createQuery(String query) {
		if(!session.isOpen())
			session = sessionFactory.openSession();
		
		return session.createQuery(query);
	}
	
	/**
	 * 
	 * @param query
	 * @return
	 */
	protected SQLQuery createSQLQuery(String query) {
		if(!session.isOpen())
			session = sessionFactory.openSession();
		
		return session.createSQLQuery(query);
	}

	/**
	 * 
	 * @param persistentClass
	 * @return
	 */
	protected Criteria createCriteria(Class<? extends MODEL> persistentClass){
		if(!session.isOpen())
			session = sessionFactory.openSession();
		
		return session.createCriteria(persistentClass);
	}
	
	@SuppressWarnings("unchecked")
	public MODEL getNewModel() {
		try {
			String className = getEdPackageModel() + getModelClassName();
			return (MODEL) Class.forName(className).newInstance();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	/**
	 * Salva o objeto<br>
	 * Faz as operacao de update e insert<br>
	 * update quando o objeto tem id<br>
	 * insert quando o objeto nao tem id
	 * @param model
	 * @return MODEL
	 */
	public MODEL save(MODEL model) {
		session.clear();
		
		if(!session.isOpen())
			session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			if (model.getId() == null) {
				model = refresh((Long) session.save(model));
			} 
			else {
				session.merge(model);
			}
		} 
		catch (HibernateException he) {
			session.getTransaction().rollback();
			log.warning(he.getMessage());
		}
		catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		finally {
			session.getTransaction().commit();
		}
		
		return model;
	}

	@Override
	public MODEL refresh(Long idModel) {
		return findById(idModel);
	}

	/**
	 * Remove o usuario da base de dados
	 */
	public void remove(MODEL model) {
		try {
			session.beginTransaction();
			session.delete(model);
		}
		catch (HibernateException he) {
			session.getTransaction().rollback();
			log.warning(he.getMessage());
		}
		catch (Exception exception) {
			session.getTransaction().rollback();
			exception.printStackTrace();
		}
		finally {
			session.getTransaction().commit();
		}
	}

	@SuppressWarnings("unchecked")
	public List<MODEL> findAll() {
		if(!StringUtils.isNotEmpty(orderFindAll))
			return createCriteria((Class<MODEL>) getNewModel().getClass()).list();
		else
			return createCriteria((Class<MODEL>) getNewModel().getClass()).addOrder(Order.asc(orderFindAll == null ? "" : orderFindAll)).list();
	}

	@SuppressWarnings("unchecked")
	public List<MODEL> findAllPropriety(String namePropriety, String valuePropriety) {
		return createQuery("FROM " + getModelClassName() + " AS model WHERE model." + namePropriety + " = :value").setString("value", valuePropriety).list();
	}

	@SuppressWarnings("unchecked")
	public MODEL findById(Long id) {
		return (MODEL) createCriteria((Class<MODEL>) getNewModel().getClass()).add(Restrictions.eq("id", id)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public MODEL findByPropriety(String namePropriety, String valuePropriety) {
		try {
			return (MODEL) createCriteria((Class<MODEL>) getNewModel().getClass()).add(Restrictions.eq(namePropriety, valuePropriety)).uniqueResult();
		} 
		catch (HibernateException he) {
			log.info(Conf.getProperty("mhb.uniqueResult"));
			
			return (MODEL) createCriteria((Class<MODEL>) getNewModel().getClass()).add(Restrictions.eq(namePropriety, valuePropriety)).setMaxResults(1).list().get(0);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<MODEL> search(String columnsFilter, String textSearch) {
		if(StringUtils.isNotEmpty(columnsFilter) && StringUtils.isNotEmpty(textSearch) ) {
			String[] columnsFilters = columnsFilter.split(", ");
			Criteria criteria = createCriteria(((Class<MODEL>) getNewModel().getClass()));
	
			Disjunction disjunction = Restrictions.disjunction();
			for (String columnKey : columnsFilters) {
				String property = columnKey.substring(columnKey.indexOf("{") + 1, columnKey.indexOf("}"));
				disjunction.add(Restrictions.or(Restrictions.like(property, "%" + textSearch + "%"), Restrictions.eq(property, textSearch)));
			}

			return criteria.add(disjunction).list();
		}
		else {
			return findAll();
		}
	}
	
	public void clearSession() {
		session.clear();
	}
}
