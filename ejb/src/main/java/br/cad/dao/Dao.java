package br.cad.dao;

import java.util.List;

import br.cad.model.Model;

/**
 * 
 * @author WilliamRodrigues <br> {@link william.rodrigues@live.fae.edu}
 *
 * @param <MODEL>
 */
public interface Dao<MODEL extends Model> {
	
	/*
	 ********************************************************************************************************************
	 ************************************************* Metodos Abstratos ************************************************
	 ********************************************************************************************************************
	 */
	
	/**
	 * Criar Novo Model para tipo proprio
	 * 
	 * @return Model
	 */
	public MODEL getNewModel();
	
	/**
	 * Salva o Model. Inserção e alteração
	 * 
	 * @param model
	 */
	public MODEL save(MODEL model);

	/**
	 * Remove o model
	 * @param model
	 */
	public void remove(MODEL model);
	
	/**
	 * Refresh o model
	 * @param model
	 */
	public MODEL refresh(Long idModel);
	
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
