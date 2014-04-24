package br.cad.model.academico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.cad.model.ModelEntity;

@Entity
@Table(name = "PlanoEstudo")
public class PlanoEstudo extends ModelEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Date dtInicio;
	private Date dtFinal;
	private Grade grade;
	private List<Turma> turmas = new ArrayList<Turma>();

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
	
	public Date getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}

	public Date getDtFinal() {
		return dtFinal;
	}

	public void setDtFinal(Date dtFinal) {
		this.dtFinal = dtFinal;
	}

	@JoinColumn(name = "grade")
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "PlanoEstudoTurma", joinColumns = { @JoinColumn(name = "plano", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "turma", referencedColumnName = "id") })
	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
	
	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Metodos *****************************************************
	 * *******************************************************************************************************************
	 */

}
