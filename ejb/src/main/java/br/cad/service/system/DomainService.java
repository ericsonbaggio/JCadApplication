package br.cad.service.system;

import java.util.List;

import br.cad.model.system.Domain;
import br.cad.service.Service;

/**
 * 
 * @author Will
 * 
 */
public interface DomainService extends Service<Domain> {

	public List<Domain> findAllUser(Long idUser);

}
