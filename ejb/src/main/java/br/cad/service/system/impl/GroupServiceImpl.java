package br.cad.service.system.impl;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import br.cad.dao.system.GroupDao;
import br.cad.model.system.Group;
import br.cad.service.impl.AbstractService;
import br.cad.service.system.GroupService;

/**
 * 
 * @author Will
 *
 */
@Service("groupService")
public class GroupServiceImpl extends AbstractService<Group, GroupDao> implements GroupService, Serializable {
	/**
	 * SerialVersion
	 */
	private static final long serialVersionUID = 1L;
	
}
