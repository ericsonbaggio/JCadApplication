package br.cad.model.academico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.cad.model.ModelEntity;
import br.cad.util.DataSistema;

@Entity
@Table(name = "Grade")
public class Grade extends ModelEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * *****************************************************************************************************************
	 * ************************************************** Atributos ****************************************************
	 * *****************************************************************************************************************
	 */

	private Date dataInicio;
	private Date dataFinal;
	private Date dataAtualizado;
	private Integer duracaoHoraAula;
	private List<Aula> aulas = new ArrayList<Aula>();

	/*
	 * *****************************************************************************************************************
	 * **************************************************** Construtor *************************************************
	 * *****************************************************************************************************************
	 */

	public Grade() {
		this.dataAtualizado = DataSistema.getDataCorrenteTimestamp();
	}

	/*
	 * ******************************************************************************************************************
	 * **************************************************** Gets e Sets *************************************************
	 * ******************************************************************************************************************
	 */

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Date getDataAtualizado() {
		return dataAtualizado;
	}

	public void setDataAtualizado(Date dataAtualizado) {
		this.dataAtualizado = dataAtualizado;
	}

	@Column(length = 2)
	public Integer getDuracaoHoraAula() {
		return duracaoHoraAula;
	}

	public void setDuracaoHoraAula(Integer duracaoHoraAula) {
		this.duracaoHoraAula = duracaoHoraAula;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "GradeAula", joinColumns = { @JoinColumn(name = "grade", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "aula", referencedColumnName = "id") })
	public List<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Metodos *****************************************************
	 * *******************************************************************************************************************
	 */

}
