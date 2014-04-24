package br.cad.controller.apps.academico;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.DualListModel;

import br.cad.controller.AbstractCrudController;
import br.cad.model.academico.Disciplina;
import br.cad.model.pessoa.Docente;
import br.cad.service.academico.DisciplinaService;
import br.cad.service.pessoa.DocenteService;
import br.cad.util.DualListModelDiff;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

@RequestScoped
@ManagedBean(name = "disciplinaController")
@URLMappings(mappings = { 
		@URLMapping(id = "disciplina-new", pattern = "/academico/disciplina/new", viewId = "/apps/academico/disciplina/new.jsf"),
		@URLMapping(id = "disciplina-list", pattern = "/academico/disciplina/list", viewId = "/apps/academico/disciplina/list.jsf"),
		@URLMapping(id = "disciplina-edit", pattern = "/academico/disciplina/edit/#{id}", viewId = "/apps/academico/disciplina/edit.jsf") })
public class DisciplinaController extends AbstractCrudController<Disciplina, DisciplinaService> implements Serializable {
	/**
	 * SerialVersion
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * *****************************************************************************************************************
	 * ************************************************** Atributos ****************************************************
	 * *****************************************************************************************************************
	 */

	@ManagedProperty("#{disciplinaService}")
	private DisciplinaService service;
	@ManagedProperty("#{docenteService}")
	private DocenteService docenteService;

	/*
	 * ******************************************************************************************************************
	 * **************************************************** Gets e Sets *************************************************
	 * ******************************************************************************************************************
	 */
	@Override
	public void setService(DisciplinaService service) {
		this.service = super.service = service;
	}

	public void setDocenteService(DocenteService docenteService) {
		this.docenteService = docenteService;
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
		this.setColumnsTemplate("{nome Nome}, {cargaHoraria CargaHoraria}");

		this.load();
	}

	public DualListModel<Docente> getDocentesAptos() {
		return new DualListModelDiff<Docente>(docenteService.findAll(), getModel().getDocentesAptos());
	}

	public void setDocentesAptos(DualListModel<Docente> docentes) {
		getModel().setDocentesAptos(docentes.getTarget());
	}

}
