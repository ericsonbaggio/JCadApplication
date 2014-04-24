package br.cad.service.system;

import java.util.List;

import br.cad.model.system.Resource;
import br.cad.service.Service;

/**
 * 
 * @author Will
 *
 */
public interface ResourceService extends Service<Resource> {

	/**
	 * Buscar todos que não tenha dóminio
	 * @return
	 */
	public List<Resource> findAllWithoutDomain();
	
	public List<Resource> findAllUser(Long idUser);
	
	public Resource findByPage(String page);
}
