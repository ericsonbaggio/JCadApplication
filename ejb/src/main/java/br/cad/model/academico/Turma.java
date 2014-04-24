package br.cad.model.academico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import br.cad.model.ModelEntity;
import br.cad.model.pessoa.Aluno;
import br.cad.model.pessoa.Docente;

@Entity
@Table(name = "Turma")
public class Turma extends ModelEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * *****************************************************************************************************************
	 * ************************************************** Atributos ****************************************************
	 * *****************************************************************************************************************
	 */

	private String codigo;
	private String Local;
	private Integer horasAula;
	private Disciplina disciplina;
	private Docente docente;
	private List<Aluno> alunos = new ArrayList<Aluno>();

	/*
	 * ******************************************************************************************************************
	 * **************************************************** Gets e Sets *************************************************
	 * ******************************************************************************************************************
	 */

	@Column(length = 25)
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	@Column(length = 100)
	public String getLocal() {
		return Local;
	}

	public void setLocal(String local) {
		Local = local;
	}

	@Range(max = 5)
	public Integer getHorasAula() {
		return horasAula;
	}

	public void setHorasAula(Integer horasAula) {
		this.horasAula = horasAula;
	}

	@JoinColumn(name = "docente")
	@NotNull(message = "Docente deve ser informado.")
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	@JoinColumn(name = "disciplina")
	@NotNull(message = "Disciplina deve ser preenchida")
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "TurmaAluno",
		joinColumns = { @JoinColumn(name = "turma", referencedColumnName = "id") },
		inverseJoinColumns = { @JoinColumn(name = "aluno", referencedColumnName = "id") })
	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Metodos *****************************************************
	 * *******************************************************************************************************************
	 */

}
