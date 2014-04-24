package br.cad.service.system.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;

import br.cad.dao.system.DomainDao;
import br.cad.model.system.Domain;
import br.cad.service.impl.AbstractService;
import br.cad.service.system.DomainService;

/**
 * 
 * @author Will
 *
 */
@Service("domainService")
public class DomainServiceImpl extends AbstractService<Domain, DomainDao> implements DomainService, Serializable {
	/**
	 * SerialVersion
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<Domain> findAllUser(Long idUser) {
		return dao.findAllUser(idUser);
	}
	
}
