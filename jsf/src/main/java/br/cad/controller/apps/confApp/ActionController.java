package br.cad.controller.apps.confApp;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang.StringUtils;

import br.cad.controller.AbstractCrudController;
import br.cad.model.system.Action;
import br.cad.model.system.ActionParameters;
import br.cad.model.system.TypeComponet;
import br.cad.service.system.ActionService;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

/**
 * 
 * @author WilliamRodrigues
 *
 */

@ViewScoped
@ManagedBean(name = "actionController")
@URLMappings(mappings = { 
		@URLMapping(id = "action-new", pattern = "/confApp/action/new", viewId = "/apps/confApp/action/new.jsf"),
		@URLMapping(id = "action-list", pattern = "/confApp/action/list", viewId = "/apps/confApp/action/list.jsf"),
		@URLMapping(id = "action-view", pattern = "/confApp/action/view/#{id}", viewId = "/apps/confApp/action/view.jsf"),
		@URLMapping(id = "action-edit", pattern = "/confApp/action/edit/#{id}", viewId = "/apps/confApp/action/edit.jsf") })
public class ActionController extends AbstractCrudController<Action, ActionService> implements Serializable {
	/**
	 * SerialVersion
	 */
	private static final long serialVersionUID = 1L;
	

	/*
	 * *****************************************************************************************************************
	 * ************************************************** Atributos ****************************************************
	 * *****************************************************************************************************************
	 */

	@ManagedProperty("#{actionService}")
	private ActionService service;
	
	private ActionParameters actionParam;

	/*
	 * *****************************************************************************************************************
	 * ************************************************ Gets e Sets ****************************************************
	 * *****************************************************************************************************************
	 */
	@Override
	public void setService(ActionService service) {
		this.service = super.service = service;
	}
	
	public ActionParameters getActionParam() {
		return actionParam;
	}
	
	public void setActionParam(ActionParameters actionParam) {
		this.actionParam = actionParam;
	}
	
	public List<TypeComponet> getTypeComponets() {
		return TypeComponet.getList();
	}
	
	public TypeComponet getPButton() {
		return TypeComponet.PBUTTON;
	}

	/*
	 * *****************************************************************************************************************
	 * ************************************************** Metodos ******************************************************
	 * *****************************************************************************************************************
	 */

	@PostConstruct
	public void init() {
		this.setColumnsTemplate("{code Código}, {name Nome}, {method Método}");
		
		this.load();
		
		actionParam = new ActionParameters();
	}
	
	public void addParam() {
		if(getModel().getParams() != null && StringUtils.isNotEmpty(actionParam.getParam())) {
			getModel().getParams().add(actionParam);
			
			actionParam = new ActionParameters();
		}
	}
	
	public void removeParam(){
		getModel().getParams().remove(actionParam);
		
		actionParam = new ActionParameters();
	}
}
