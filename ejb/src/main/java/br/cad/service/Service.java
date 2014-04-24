package br.cad.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import br.cad.model.Model;

/**
 * 
 * @author Will
 *
 * @param <MODEL>
 */
@Transactional(readOnly=true)
public interface Service<MODEL extends Model> {		
	/**
	 * Criar Novo Mode para tipo proprio
	 * 
	 * @return Model
	 */
	public MODEL getNewModel();	
	
	/**
	 * Salva o Model. Insercao e alteracao
	 * 
	 * @param model
	 */
	@Transactional(readOnly=false)
	public MODEL save(MODEL model);

	/**
	 * Remove o model
	 * @param model
	 */
	@Transactional(readOnly=false)
	public void remove(MODEL model);
	
	/**
	 * Busca todos os models
	 * 
	 * @return Model
	 */
	public List<MODEL> findAll();
	
	/**
	 * Busca todos os model pela propriedade
	 * 
	 * @return
	 * @param namePropriety
	 * @param valuePropriety
	 */
	public List<MODEL> findAllPropriety(String namePropriety, String valuePropriety);
		
	/**
	 * Procura um model por id
	 * @param id 
	 * @return Model encontrado
	 */
	public MODEL findById(Long id);
	
	/**
	 * Busca um model pela propriedade
	 * 
	 * @return
	 * @param namePropriety
	 * @param valuePropriety
	 */
	public MODEL findByPropriety(String namePropriety, String valuePropriety);
	
	/**
	 * Metodo de busca
	 * @param colunmsFilter
	 * @param textSearch
	 * @return
	 */
	public List<MODEL> search(String columnsFilter, String textSearch);
	
	public void clearSession();
}
