package br.cad.model.academico;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.cad.model.ModelEntity;
import br.cad.model.pessoa.Aluno;

@Entity
@Table(name = "Chamada")
public class Chamada extends ModelEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Boolean presenca;
	private Aluno aluno;
	private Aula aula;

	/*
	 * *****************************************************************************************************************
	 * **************************************************** Construtor *************************************************
	 * *****************************************************************************************************************
	 */

	/*
	 * ******************************************************************************************************************
	 * **************************************************** Gets e Sets *************************************************
	 * ******************************************************************************************************************
	 */

	@NotNull
	@Column(columnDefinition = "int default 1")
	public Boolean getPresenca() {
		return presenca;
	}

	public void setPresenca(Boolean presenca) {
		this.presenca = presenca;
	}

	@JoinColumn(name = "aluno")
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@JoinColumn(name = "aula")
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Metodos *****************************************************
	 * *******************************************************************************************************************
	 */
}
