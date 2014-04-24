package br.cad.model.academico;

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

import br.cad.model.ModelEntity;
import br.cad.model.pessoa.Docente;

@Entity
@Table(name = "Disciplina")
public class Disciplina extends ModelEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * *****************************************************************************************************************
	 * ************************************************** Atributos ****************************************************
	 * *****************************************************************************************************************
	 */

	private String nome;
	private Double cargaHoraria;
	
	private List<Docente> docentesAptos = new ArrayList<Docente>();

	/*
	 * ******************************************************************************************************************
	 * **************************************************** Gets e Sets *************************************************
	 * ******************************************************************************************************************
	 */
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Double cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "DocenteDisciplina",
			joinColumns = { @JoinColumn(name = "disciplina", referencedColumnName = "id") },
			inverseJoinColumns = { @JoinColumn(name = "docente", referencedColumnName = "id") })
	public List<Docente> getDocentesAptos() {
		return docentesAptos;
	}

	public void setDocentesAptos(List<Docente> docentesAptos) {
		this.docentesAptos = docentesAptos;
	}

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Metodos *****************************************************
	 * *******************************************************************************************************************
	 */
	
}
