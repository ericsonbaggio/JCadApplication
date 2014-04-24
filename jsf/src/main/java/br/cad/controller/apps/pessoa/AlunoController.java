package br.cad.controller.apps.pessoa;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.cad.controller.AbstractCrudController;
import br.cad.model.pessoa.Aluno;
import br.cad.model.system.User;
import br.cad.service.academico.DisciplinaService;
import br.cad.service.pessoa.AlunoService;
import br.cad.util.Conf;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

@ViewScoped
@ManagedBean(name = "alunoController")
@URLMappings(mappings = { 
		@URLMapping(id = "aluno-new", pattern = "/pessoa/aluno/new", viewId = "/apps/pessoa/aluno/new.jsf"),
		@URLMapping(id = "aluno-list", pattern = "/pessoa/aluno/list", viewId = "/apps/pessoa/aluno/list.jsf"),
		@URLMapping(id = "aluno-edit", pattern = "/pessoa/aluno/edit/#{id}", viewId = "/apps/pessoa/aluno/edit.jsf") })
public class AlunoController extends AbstractCrudController<Aluno, AlunoService> implements Serializable {
	/**
	 * SerialVersion
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * *****************************************************************************************************************
	 * ************************************************** Atributos ****************************************************
	 * *****************************************************************************************************************
	 */

	@ManagedProperty("#{alunoService}")
	private AlunoService service;
	@ManagedProperty("#{disciplinaService}")
	private DisciplinaService disciplinaService;


	/*
	 * ******************************************************************************************************************
	 * **************************************************** Gets e Sets *************************************************
	 * ******************************************************************************************************************
	 */
	
	@Override
	public void setService(AlunoService service) {
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
	protected Aluno getNewModel() {
		User usuario = new User();
		Aluno aluno = service.getNewModel();
		aluno.setUsuario(usuario);
		return aluno;
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
