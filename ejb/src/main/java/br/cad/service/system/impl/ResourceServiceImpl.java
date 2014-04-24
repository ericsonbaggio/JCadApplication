package br.cad.service.system.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;

import br.cad.dao.system.ResourceDao;
import br.cad.model.system.Resource;
import br.cad.service.impl.AbstractService;
import br.cad.service.system.ResourceService;

/**
 * 
 * @author Will
 * 
 */
@Service("resourceService")
public class ResourceServiceImpl extends AbstractService<Resource, ResourceDao> implements ResourceService, Serializable {
	/**
	 * SerialVersion
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<Resource> findAllWithoutDomain() {
		return dao.findAllWithoutDomain();
	}

	@Override
	public List<Resource> findAllUser(Long idUser) {
		return dao.findAllUser(idUser);
	}

	@Override
	public Resource findByPage(String page) {
		return dao.findByPage(page);
	}
}
