package br.cad.model.academico;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.cad.model.ModelEntity;
import br.cad.model.pessoa.Aluno;

@Entity
@Table(name = "Nota")
public class Nota extends ModelEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String tipoNota;
	private Double valorNota;
	private Aluno aluno;
	private Disciplina disciplina;

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
	public String getTipoNota() {
		return tipoNota;
	}

	public void setTipoNota(String tipoNota) {
		this.tipoNota = tipoNota;
	}

	@NotNull
	public Double getValorNota() {
		return valorNota;
	}

	public void setValorNota(Double valorNota) {
		this.valorNota = valorNota;
	}

	@JoinColumn(name = "aluno")
	@ManyToOne(fetch = FetchType.LAZY)
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@JoinColumn(name = "disciplina")
	@ManyToOne(fetch = FetchType.LAZY)
	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

}
