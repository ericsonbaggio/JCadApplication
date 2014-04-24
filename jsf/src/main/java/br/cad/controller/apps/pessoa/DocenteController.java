package br.cad.controller.apps.pessoa;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.DualListModel;

import br.cad.controller.AbstractCrudController;
import br.cad.model.academico.Disciplina;
import br.cad.model.pessoa.Docente;
import br.cad.model.system.User;
import br.cad.service.academico.DisciplinaService;
import br.cad.service.pessoa.DocenteService;
import br.cad.util.Conf;
import br.cad.util.DualListModelDiff;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

@ViewScoped
@ManagedBean(name = "docenteController")
@URLMappings(mappings = { 
		@URLMapping(id = "docente-new", pattern = "/pessoa/docente/new", viewId = "/apps/pessoa/docente/new.jsf"),
		@URLMapping(id = "docente-list", pattern = "/pessoa/docente/list", viewId = "/apps/pessoa/docente/list.jsf"),
		@URLMapping(id = "docente-edit", pattern = "/pessoa/docente/edit/#{id}", viewId = "/apps/pessoa/docente/edit.jsf") })
public class DocenteController extends AbstractCrudController<Docente, DocenteService> implements Serializable {
	/**
	 * SerialVersion
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * *****************************************************************************************************************
	 * ************************************************** Atributos ****************************************************
	 * *****************************************************************************************************************
	 */

	@ManagedProperty("#{docenteService}")
	private DocenteService service;
	@ManagedProperty("#{disciplinaService}")
	private DisciplinaService disciplinaService;


	/*
	 * ******************************************************************************************************************
	 * **************************************************** Gets e Sets *************************************************
	 * ******************************************************************************************************************
	 */
	
	@Override
	public void setService(DocenteService service) {
		this.service = super.service = service;
	}
	public void setDisciplinaService(DisciplinaService disciplinaService) {
		this.disciplinaService = disciplinaService;
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
	protected Docente getNewModel() {
		User usuario = new User();
		Docente docente = service.getNewModel();
		docente.setUsuario(usuario);
		return docente;
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
	public DualListModel<Disciplina> getDisciplinas() {
		return new DualListModelDiff<Disciplina>(disciplinaService.findAll(), getModel().getDisciplinasAptas());
	}

	public void setDisciplinas(DualListModel<Disciplina> disciplinas) {
		getModel().setDisciplinasAptas(disciplinas.getTarget());
	}

}
