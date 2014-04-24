package br.cad.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.primefaces.event.SelectEvent;

import br.cad.model.Model;
import br.cad.service.Service;
import br.cad.util.Conf;
import br.cad.util.DynamicColluns;
import br.cad.util.DynamicColluns.ColumnModel;

public abstract class AbstractCrudController<MODEL extends Model, SERVICE extends Service<MODEL>> extends AppController implements Serializable {
	/**
	 * SerialVersion
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * *****************************************************************************************************************
	 * ************************************************** Atributos ****************************************************
	 * *****************************************************************************************************************
	 */

	protected SERVICE service;
	private MODEL model;
	private List<MODEL> models = new ArrayList<MODEL>();

	private DynamicColluns<MODEL> dynamicColluns;
	private String columnsTemplate;
	private String columnsFilter;
	private String columnsLabel;
	private String textSearch;

	/*
	 * ******************************************************************************************************************
	 * **************************************************** Gets e Sets *************************************************
	 * ******************************************************************************************************************
	 */

	public SERVICE getService() {
		return service;
	}

	public abstract void setService(SERVICE service);

	/**
	 * Objeto pricipal
	 * 
	 * @return
	 */
	public MODEL getModel() {
		return model;
	}

	public void setModel(MODEL model) {
		this.model = model;
	}

	/**
	 * Gera nova instancio do objeto principal
	 * 
	 * @return
	 */
	protected MODEL getNewModel() {
		return service.getNewModel();
	}

	/**
	 * List do objeto principalS
	 * 
	 * @return
	 */
	public List<MODEL> getModels() {
		return models;
	}

	public void setModels(List<MODEL> models) {
		this.models = models;
	}

	public DynamicColluns<MODEL> getDynamicColluns() {
		return dynamicColluns;
	}

	public void setDynamicColluns(DynamicColluns<MODEL> dynamicColluns) {
		this.dynamicColluns = dynamicColluns;
	}

	/**
	 * Template das colunas para o dataTable<br> 
	 * Example:<br>
	 * 	"{propriety name}, {propriety name}"
	 * 	
	 **/
	public String getColumnsTemplate() {
		return columnsTemplate;
	}

	public void setColumnsTemplate(String columnsTemplate) {
		this.columnsTemplate = columnsTemplate;
	}

	public String getColumnsFilter() {
		return columnsFilter;
	}

	public void setColumnsFilter(String columnsFilter) {
		this.columnsFilter = columnsFilter;
	}

	public String getColumnsLabel() {
		return columnsLabel;
	}

	public void setColumnsLabel(String columnsLabel) {
		this.columnsLabel = columnsLabel;
	}

	public String getTextSearch() {
		return textSearch;
	}

	public void setTextSearch(String textSearch) {
		this.textSearch = textSearch;
	}

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Metodos *****************************************************
	 * *******************************************************************************************************************
	 */
	
	/**
	 * Metodo para sair ou fazer logoff
	 * 
	 * @return pagina
	 */
	public void logout() {
		clearSession();
		
		getSession().remove("userLogged");
		getSession().remove("domainUser");
		getSession().remove("resourceUser");

		// Removendo o Cookie
		removeCookie("userLoginName", getResponse());
		removeCookie("keyUser", getResponse());
	}
	
	/**
	 * Limpar a sessao
	 */
	public void clearSession() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		session.invalidate();
		
		service.clearSession();
	}
	
	/**
	 * Criar novo model
	 */
	public void newModel() {
		try {
			 model = getNewModel();
		}
		catch(Exception e) {
			getMsgError(e.getMessage());
		}
	}
	
	/**
	 * Metodod que chama todos models de um objeto
	 */
	public void findAll() {
		this.setModels(service.findAll());

		// Configuracao do filtro 
		if(StringUtils.isNotEmpty(columnsTemplate)){
			String[] columnsFilters = columnsTemplate.split(", ");
			String filters = "";
			String label = "";

			for (String columnKey : columnsFilters) {
				if (filters.length() > 0)
					filters+=", ";
				if (label.length() > 0)
					label+=", ";
				
				String property = columnKey.substring(columnKey.indexOf("{") + 1, columnKey.indexOf(" "));
				String header = columnKey.substring(columnKey.indexOf(" ") + 1, columnKey.lastIndexOf("}"));

				label += header; 
				
				filters += "{" + property + "}";
			}
			
			columnsFilter = filters;
			columnsLabel = label;
		}
	}
	
	/**
	 * Este metodo e chamado para carregar o objeto por ID oucriar um Novo
	 */
	public void load() {
		// Pegando o parametro id da URL
		this.idURL = StringUtils.isNotEmpty(getParam("id")) ? getParam("id") : null;

		if (!StringUtils.isNotEmpty(idURL)) {
			this.newModel();
			
			this.msg = Conf.getProperty("msg.save");
			
			if(StringUtils.isNotEmpty(columnsTemplate)){
				this.listModel();
				
				this.findAll();
			}
		} 
		else {
			// Quando o id e passado como parametro abrimos o formulurio para edicao
			this.model = service.findById(new Long(idURL));

			this.msg = Conf.getProperty("msg.update");

			// Verifica se foi setado um model se nao foi cria um novo model com aquele id
			if (model == null) {
				this.newModel();
			}
		}
		
		log = Logger.getLogger(this.getClass().getSimpleName());
		
		this.selectedResource();
	}

	/**
	 * Este metodo e chamado para salvar o Objeto
	 */
	public void save() {
		try {
			this.msg = model.getId() != null ? Conf.getProperty("msg.update") : msg;

			model = service.save(getModel());
			
			// Mandando uma mensagem para a tela
			this.getMsgInfo(msg);
		} 
		catch (Exception e) {
			this.getMsgError(e.getMessage());
		}
		
		this.getRefreshViewComponent(":frm");
	}
	
	/**
	 * Metodo de exclusao do Objeto
	 */
	public void delete() {
		log.info("SELECTED ID: " + (getSession().get("idObject") == null ? id : getSession().get("idObject")));

		id = getSession().get("idObject") != null ? (Long) getSession().get("idObject") : id;

		try {
			if (id != null) {
				model = service.findById(id);
				if (model != null) {
					this.service.remove(model);
					
					// Chama o buscaTodos para atualizar a lista
					this.findAll();
					// Atualizar o :frm após remover
					this.getRefreshViewComponent(":frm");
					this.getMsgError(Conf.getProperty("msg.delete"));
					
					this.getSession().remove("idObject");
					log.info("EXCLUDED OBJECT ID: " + id);
				}
			}
			else {
				this.getMsgWarn(Conf.getProperty("msg.unperformed"));
			}			
		} 
		catch (Exception e) {
			this.getMsgError(e.getMessage());
		}

		if(getFindComponent("dlgActions") != null) {
			this.getExecuteScript("dlgActions.hide();");
		}
		
		this.getRefreshViewComponent(":frm");
	}
	
	public void create() {
		this.getRedirect(contexPath() + resourceSelected.getLocationOfFiles() + "new");
	}
	
	/**
	 * Acao de editar
	 */
	public void edit() {
		log.info("ID do Objeto selecionado: " + (getSession().get("idObject") == null ? id : getSession().get("idObject")));
		
		this.id = getSession().get("idObject") != null ? (Long) getSession().get("idObject") : id;
		
		if (id != null) {
			this.getRedirect(contexPath() + resourceSelected.getLocationOfFiles() + "edit/" + id);
		}
		
		this.getSession().remove("idObject");
	}
	
	/**
	 * Acao de listar
	 */
	public void list() {
		this.getRedirect(contexPath() + resourceSelected.getLocationOfFiles() + "list");
	}

	/**
	 * Acao de exibir
	 */
	public void view() {
		log.info("ID do Objeto selecionado: " + (getSession().get("idObject") == null ? id : getSession().get("idObject")));
		
		this.id = getSession().get("idObject") != null ? (Long) getSession().get("idObject") : id;
		
		if (id != null) {
			this.getRedirect(contexPath() + resourceSelected.getLocationOfFiles() + "view/" + id);
		}
		
		this.getSession().remove("idObject");
	}
	
	/**
	 * Carregar pagina padrao do recurso
	 */
	public void pageLoad() {
		if(resourceSelected != null)
			getRedirect(contexPath() +  resourceSelected.getLocationOfFiles() + resourceSelected.getIndexPage());
	}
	
	/**
	 * Criar a lista dos objetos
	 */
	protected void listModel(){
		if(dynamicColluns != null && StringUtils.isNotEmpty(dynamicColluns.getColumnTemplate())){
			dynamicColluns.createDynamicColumns();
		}
		else{
			dynamicColluns = new DynamicColluns<MODEL>(model, columnsTemplate);
			dynamicColluns.createDynamicColumns();
		}
	}
	
	/**
	 * Colunas para o dataTable dynamic
	 * 
	 * @return
	 */
	public List<ColumnModel> getColumnsDateTable() {
		if(dynamicColluns != null && dynamicColluns.getColumns() != null){
			return dynamicColluns.getColumns();
		}
		else{
			return null;
		}
	}
	
	/**
	 * Metodo de Busca 
	 */
	public void search() {
		models = service.search(columnsFilter, textSearch);
	}
	
	@SuppressWarnings("unchecked")
	public void onRowSelect(SelectEvent event) {
		getSession().put("idObject", ((MODEL) event.getObject()).getId());

		if(getFindComponent("dlgActions") != null) {
			getExecuteScript("dlgActions.show();");
		}
		
		model.setId(((MODEL) event.getObject()).getId());
	}

}
