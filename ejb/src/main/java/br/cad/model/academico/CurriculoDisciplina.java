package br.cad.model.academico;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import br.cad.model.ModelEntity;

@Entity
@Table(name = "CurriculoDisciplina")
public class CurriculoDisciplina extends ModelEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * *****************************************************************************************************************
	 * ************************************************** Atributos ****************************************************
	 * *****************************************************************************************************************
	 */

	private Integer periodo;
	private Disciplina disciplina;
	private Ementa ementa;

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

	@Range(max = 2)
	public Integer getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}

	@JoinColumn(name = "disciplina")
	@NotNull(message = "Disciplina requerida.")
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	@JoinColumn(name = "ementa")
	@NotNull(message = "Ementa requerida.")
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Ementa getEmenta() {
		return ementa;
	}

	public void setEmenta(Ementa ementa) {
		this.ementa = ementa;
	}

	/*
	 * *****************************************************************************************************************
	 * ***************************************************** Metodos ***************************************************
	 * *****************************************************************************************************************
	 */
}
