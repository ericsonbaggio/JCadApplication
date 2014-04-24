package br.cad.controller.apps.confApp;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.cad.controller.AbstractCrudController;
import br.cad.model.system.Domain;
import br.cad.service.system.DomainService;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

/**
 * 
 * @author WilliamRodrigues
 * 
 */
@ViewScoped
@ManagedBean(name = "domainController")
@URLMappings(mappings = { 
		@URLMapping(id = "domain-new", pattern = "/confApp/domain/new", viewId = "/apps/confApp/domain/new.jsf"),
		@URLMapping(id = "domain-list", pattern = "/confApp/domain/list", viewId = "/apps/confApp/domain/list.jsf"),
		@URLMapping(id = "domain-view", pattern = "/confApp/domain/view/#{id}", viewId = "/apps/confApp/domain/view.jsf"),
		@URLMapping(id = "domain-edit", pattern = "/confApp/domain/edit/#{id}", viewId = "/apps/confApp/domain/edit.jsf") })
public class DomainController extends AbstractCrudController<Domain, DomainService> implements Serializable {
	/**
	 * SerialVersion
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * *****************************************************************************************************************
	 * ************************************************** Atributos ****************************************************
	 * *****************************************************************************************************************
	 */

	@ManagedProperty("#{domainService}")
	private DomainService service;
	
	private Domain subDomain;

	/*
	 * *****************************************************************************************************************
	 * ************************************************ Gets e Sets ****************************************************
	 * *****************************************************************************************************************
	 */
	@Override
	public void setService(DomainService service) {
		this.service = super.service = service;
	}
	
	public Domain getSubDomain() {
		return subDomain;
	}

	public void setSubDomain(Domain subDomain) {
		this.subDomain = subDomain;
	}
	
	/*
	 * *****************************************************************************************************************
	 * ************************************************** Metodos ******************************************************
	 * *****************************************************************************************************************
	 */
	
	@PostConstruct
	public void init() {
		this.setColumnsTemplate("{name Nome}");

		this.load();
	}
	
	public void viewAddSubDomain() {
		subDomain = new Domain();

		getRefreshViewComponent("dlSubDomain");
		
		getExecuteScript("dlSubDomain.show();");
	}
	
	public void closeSubDomain() {
		getExecuteScript("dlSubDomain.hide();");
	}
}
