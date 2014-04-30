package br.cad.model.academico;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonIgnore;

import br.cad.model.ModelEntity;
import br.cad.model.pessoa.Aluno;

@Entity
@Table(name = "Matricula")
public class Matricula extends ModelEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * *****************************************************************************************************************
	 * ************************************************** Atributos ****************************************************
	 * *****************************************************************************************************************
	 */
	private Aluno aluno;
	private Curso curso;
	private MatrizCurricular curriculo;

	/*
	 * ******************************************************************************************************************
	 * **************************************************** Gets e Sets *************************************************
	 * ******************************************************************************************************************
	 */

	@JsonIgnore
	@JoinColumn(name = "aluno")
	@NotNull(message = "Aluno requerido.")
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	@Transient
	public Long getAluno_id() {
		return aluno.getId();
	}

	@JsonIgnore
	@JoinColumn(name = "curso")
	@NotNull(message = "Curso requerido.")
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	@Transient
	public Long getCurso_id() {
		return curso.getId();
	}

	@JsonIgnore
	@JoinColumn(name = "curriculo")
	@NotNull(message = "Curriculo requerido.")
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public MatrizCurricular getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(MatrizCurricular curriculo) {
		this.curriculo = curriculo;
	}
	
	@Transient
	public Long getCurriculo_id() {
		return curso.getId();
	}

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Metodos *****************************************************
	 * *******************************************************************************************************************
	 */

}
