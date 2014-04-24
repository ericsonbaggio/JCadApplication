package br.cad.controller.apps.academico;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.DualListModel;

import br.cad.controller.AbstractCrudController;
import br.cad.model.academico.Curso;
import br.cad.model.academico.Disciplina;
import br.cad.service.academico.CursoService;
import br.cad.service.academico.DisciplinaService;
import br.cad.util.DualListModelDiff;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

@ViewScoped
@ManagedBean(name = "cursoController")
@URLMappings(mappings = { 
		@URLMapping(id = "curso-new", pattern = "/academico/curso/new", viewId = "/apps/academico/curso/new.jsf"),
		@URLMapping(id = "curso-list", pattern = "/academico/curso/list", viewId = "/apps/academico/curso/list.jsf"),
		@URLMapping(id = "curso-edit", pattern = "/academico/curso/edit/#{id}", viewId = "/apps/academico/curso/edit.jsf") })
public class CursoController extends AbstractCrudController<Curso, CursoService> implements Serializable {
	/**
	 * SerialVersion
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * *****************************************************************************************************************
	 * ************************************************** Atributos ****************************************************
	 * *****************************************************************************************************************
	 */

	@ManagedProperty("#{cursoService}")
	private CursoService service;
	@ManagedProperty("#{disciplinaService}")
	private DisciplinaService disciplinaService;

	/*
	 * ******************************************************************************************************************
	 * **************************************************** Gets e Sets *************************************************
	 * ******************************************************************************************************************
	 */
	
	@Override
	public void setService(CursoService service) {
		this.service = super.service = service;
	}
	public void setDisciplinaService(DisciplinaService disciplinaService) {
		this.disciplinaService = disciplinaService;
	}

	public DualListModel<Disciplina> getDisciplinas() {
		return new DualListModelDiff<Disciplina>(disciplinaService.findAll(), getModel().getDisciplinas());
	}

	public void setDisciplinas(DualListModel<Disciplina> disciplinas) {
		getModel().setDisciplinas(disciplinas.getTarget());
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
		this.setColumnsTemplate("{nome Nome}, {duracao Duracao}");
		
		this.load();
	}
}
