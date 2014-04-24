package br.cad.controller.apps.pessoa;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.cad.controller.AbstractCrudController;
import br.cad.model.pessoa.Administrador;
import br.cad.model.system.User;
import br.cad.service.pessoa.AdministradorService;
import br.cad.service.system.GroupService;
import br.cad.util.Conf;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

@ViewScoped
@ManagedBean(name = "administradorController")
@URLMappings(mappings = { 
		@URLMapping(id = "administrador-new", pattern = "/pessoa/administrador/new", viewId = "/apps/pessoa/administrador/new.jsf"),
		@URLMapping(id = "administrador-list", pattern = "/pessoa/administrador/list", viewId = "/apps/pessoa/administrador/list.jsf"),
		@URLMapping(id = "administrador-edit", pattern = "/pessoa/administrador/edit/#{id}", viewId = "/apps/pessoa/administrador/edit.jsf") })
public class AdministradorController extends AbstractCrudController<Administrador, AdministradorService> implements Serializable {
	/**
	 * SerialVersion
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * *****************************************************************************************************************
	 * ************************************************** Atributos ****************************************************
	 * *****************************************************************************************************************
	 */

	@ManagedProperty("#{administradorService}")
	private AdministradorService service;
	@ManagedProperty("#{groupService}")
	private GroupService groupService;


	/*
	 * ******************************************************************************************************************
	 * **************************************************** Gets e Sets *************************************************
	 * ******************************************************************************************************************
	 */
	
	@Override
	public void setService(AdministradorService service) {
		this.service = super.service = service;
	}
	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}

	
	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Metodos *****************************************************
	 * *******************************************************************************************************************
	 */

	/**
	 * Metodo iniciado na construcao da Classe
	 */
	@PostConstruct
	public void iniciar() {
		this.setColumnsTemplate("{nomeCompleto nomeCompleto}, {nomeAbreviado nomeAbreviado}");
		this.load();
	}
	@Override
	protected Administrador getNewModel() {
		User usuario = new User();
		Administrador administrador = service.getNewModel();
		administrador.setUsuario(usuario);
		return administrador;
	}
	@Override
	public void save() {
		try {
			this.msg = getModel().getId() != null ? Conf.getProperty("msg.update") : msg;
			User usuario = getModel().getUsuario();
			usuario.setName( getModel().getNomeCompleto() );
			getModel().setUsuario(usuario);
			setModel(service.save(getModel()));
			
			// Mandando uma mensagem para a tela
			this.getMsgInfo(msg);
		} 
		catch (Exception e) {
			this.getMsgError(e.getMessage());
		}
		
		this.getRefreshViewComponent(":frm");
	}

}
