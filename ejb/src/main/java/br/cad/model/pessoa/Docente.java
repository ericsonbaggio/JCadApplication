package br.cad.model.pessoa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.cad.model.academico.Disciplina;

@Entity
@Table(name = "Docente")
public class Docente extends PessoaPapel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * *****************************************************************************************************************
	 * ************************************************** Atributos ****************************************************
	 * *****************************************************************************************************************
	 */

	private String ra;
	private List<Disciplina> disciplinasAptas = new ArrayList<Disciplina>();

	/*
	 * ******************************************************************************************************************
	 * **************************************************** Gets e Sets *************************************************
	 * ******************************************************************************************************************
	 */
	
	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "DocenteDisciplina",
			joinColumns = { @JoinColumn(name = "docente", referencedColumnName = "id") },
			inverseJoinColumns = { @JoinColumn(name = "disciplina", referencedColumnName = "id") })
	public List<Disciplina> getDisciplinasAptas() {
		return disciplinasAptas;
	}
	
	public void setDisciplinasAptas(List<Disciplina> disciplinasAptas) {
		this.disciplinasAptas = disciplinasAptas;
	}
	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Metodos *****************************************************
	 * *******************************************************************************************************************
	 */


}
