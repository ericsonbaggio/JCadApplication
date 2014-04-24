package br.cad.controller.apps.academico;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.DualListModel;

import br.cad.controller.AbstractCrudController;
import br.cad.model.academico.Disciplina;
import br.cad.model.academico.Turma;
import br.cad.model.pessoa.Aluno;
import br.cad.model.pessoa.Docente;
import br.cad.service.academico.DisciplinaService;
import br.cad.service.academico.TurmaService;
import br.cad.service.pessoa.AlunoService;
import br.cad.service.pessoa.DocenteService;
import br.cad.util.DualListModelDiff;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

@ViewScoped
@ManagedBean(name = "turmaController")
@URLMappings(mappings = { 
		@URLMapping(id = "turma-new", pattern = "/academico/turma/new", viewId = "/apps/academico/turma/new.jsf"),
		@URLMapping(id = "turma-list", pattern = "/academico/turma/list", viewId = "/apps/academico/turma/list.jsf"),
		@URLMapping(id = "turma-edit", pattern = "/academico/turma/edit/#{id}", viewId = "/apps/academico/turma/edit.jsf") })
public class TurmaController extends AbstractCrudController<Turma, TurmaService> {
	/**
	 * SerialVersion
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * *****************************************************************************************************************
	 * ************************************************** Atributos ****************************************************
	 * *****************************************************************************************************************
	 */

	@ManagedProperty("#{turmaService}")
	private TurmaService service;
	@ManagedProperty("#{alunoService}")
	private AlunoService alunoService;
	@ManagedProperty("#{disciplinaService}")
	private DisciplinaService disciplinaService;
	@ManagedProperty("#{docenteService}")
	private DocenteService docenteService;

	/*
	 * ******************************************************************************************************************
	 * **************************************************** Gets e Sets *************************************************
	 * ******************************************************************************************************************
	 */
	
	@Override
	public void setService(TurmaService service) {
		this.service = super.service = service;
	}
	
	public void setAlunoService(AlunoService alunoService) {
		this.alunoService = alunoService;
	}
	
	public void setDisciplinaService(DisciplinaService disciplinaService) {
		this.disciplinaService = disciplinaService;
	}
	public void setDocenteService(DocenteService docenteService) {
		this.docenteService = docenteService;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinaService.findAll();
	}
	
	public List<Docente> getDocentes() {
		return docenteService.findAll();
	}

	public DualListModel<Aluno> getAlunos() {
		return new DualListModelDiff<Aluno>(alunoService.findAll(), getModel().getAlunos());
	}

	public void setAlunos(DualListModel<Aluno> alunos) {
		getModel().setAlunos(alunos.getTarget());
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
		this.setColumnsTemplate("{codigo Codigo}, {local Local}, {horasAula Horas/Aula}");
		
		this.load();
	}
}
