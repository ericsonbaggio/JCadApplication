package br.cad.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import br.cad.dao.Dao;
import br.cad.model.Model;
import br.cad.service.Service;

/**
 * 
 * @author WilliamRodrigues
 * 
 * @param <MODEL>
 * @param <DAO>
 */
public abstract class AbstractService<MODEL extends Model, DAO extends Dao<MODEL>> implements Service<MODEL>, ApplicationContextAware {
	protected DAO dao;

	@SuppressWarnings("unchecked")
	public void setApplicationContext(ApplicationContext ctx) {
		String name = this.getClass().getSimpleName();
		if (name.endsWith("ServiceImpl")) {
			name = name.substring(0, name.length() - 11);
			name = StringUtils.uncapitalize(name) + "Dao";
			
			//Cria o DAO para o MODEL
			dao = (DAO) ctx.getBean(name);
		}

	}

	public MODEL getNewModel() {
		return dao.getNewModel();
	}

	public MODEL save(MODEL model) {
		return dao.save(model);
	}

	public void remove(MODEL model) {
		dao.remove(model);
	}

	public List<MODEL> findAll() {
		return dao.findAll();
	}

	public List<MODEL> findAllPropriety(String namePropriety, String valuePropriety) {
		return dao.findAllPropriety(namePropriety, valuePropriety);
	}

	public MODEL findById(Long id) {
		return dao.findById(id);
	}

	public MODEL findByPropriety(String namePropriety, String valuePropriety) {
		return dao.findByPropriety(namePropriety, valuePropriety);
	}

	public List<MODEL> search(String columnsFilter, String textSearch) {
		return dao.search(columnsFilter, textSearch);
	}
	
	public void clearSession(){
		dao.clearSession();
	}

}
