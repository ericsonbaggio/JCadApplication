package br.cad.controller.apps.confApp;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang.StringUtils;
import org.primefaces.model.DualListModel;

import br.cad.controller.AbstractCrudController;
import br.cad.model.system.Action;
import br.cad.model.system.Domain;
import br.cad.model.system.Resource;
import br.cad.model.system.ResourceFile;
import br.cad.service.system.ActionService;
import br.cad.service.system.DomainService;
import br.cad.service.system.ResourceService;
import br.cad.util.DualListModelDiff;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

/**
 * 
 * @author WilliamRodrigues
 * 
 */

@ViewScoped
@ManagedBean(name = "resourceController")
@URLMappings(mappings = { 
		@URLMapping(id = "resource-new", pattern = "/confApp/resource/new", viewId = "/apps/confApp/resource/new.jsf"),
		@URLMapping(id = "resource-list", pattern = "/confApp/resource/list", viewId = "/apps/confApp/resource/list.jsf"),
		@URLMapping(id = "resource-view", pattern = "/confApp/resource/view/#{id}", viewId = "/apps/confApp/resource/view.jsf"),
		@URLMapping(id = "resource-edit", pattern = "/confApp/resource/edit/#{id}", viewId = "/apps/confApp/resource/edit.jsf"),
		@URLMapping(id = "resource-pages", pattern = "/confApp/resource/pages/#{id}/#{page}", viewId = "/apps/confApp/resource/pages.jsf") })
public class ResourceController extends AbstractCrudController<Resource, ResourceService> implements Serializable {
	/**
	 * SerialVersion
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * *****************************************************************************************************************
	 * ************************************************** Atributos ****************************************************
	 * *****************************************************************************************************************
	 */

	@ManagedProperty("#{resourceService}")
	private ResourceService service;
	@ManagedProperty("#{actionService}")
	private ActionService actionService;
	@ManagedProperty("#{domainService}")	
	private DomainService domainService;
	
	private ResourceFile page;
	private Action actionPage;

	/*
	 * *****************************************************************************************************************
	 * ************************************************ Gets e Sets ****************************************************
	 * *****************************************************************************************************************
	 */

	@Override
	public void setService(ResourceService service) {
		this.service = super.service = service;
	}

	public void setActionService(ActionService actionService) {
		this.actionService = super.actionService = actionService;
	}

	public void setDomainService(DomainService domainService) {
		this.domainService = super.domainService = domainService;
	}

	public DualListModel<Action> getResourceAction() {
		return new DualListModelDiff<Action>(actionService.findAll(), getModel().getActions());
	}

	public void setResourceAction(DualListModel<Action> actions) {
		this.getModel().setActions(actions.getTarget());
	}
	
	public List<Action> getActionsPage() {
		return actionService.findAllByResource(getModel().getId());
	}
	
	public List<Domain> getDomains(){
		return domainService.findAll();
	}

	public ResourceFile getPage() {
		return page;
	}
	
	public void setPage(ResourceFile page) {
		this.page = page;
	}

	public Action getActionPage() {
		return actionPage;
	}

	public void setActionPage(Action actionPage) {
		this.actionPage = actionPage;
	}

	/*
	 * *****************************************************************************************************************
	 * ************************************************** Metodos ******************************************************
	 * *****************************************************************************************************************
	 */

	@PostConstruct
	public void init() {
		this.setColumnsTemplate("{domain.name Domínio}, {name Nome}, {controllerBean Controller}, {objectClass Classe}");

		this.load();
		
		if (StringUtils.isNotEmpty(getParam("page"))) {
			Long idPage = new Long(getParam("page"));
			
			for (ResourceFile file : getModel().getFiles()) {
				if (file.getId().equals(idPage)) {
					page = file;
					break;
				}
			}
		}
		else {
			this.newPage();
		}
	}
	
	public void newPage() {
		page = new ResourceFile();
	}
	
	public void editActionsPage() {
		if (getModel().getId() !=  null && page.getId() != null) {
			getRedirect(contexPath() + "confApp/resource/pages/" + getModel().getId() + "/" + page.getId());
		}
	}

	@Override
	public void findAll() {
		service.clearSession();
		
		super.findAll();
	}
}
