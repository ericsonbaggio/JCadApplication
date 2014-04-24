package br.cad.model.academico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.cad.model.ModelEntity;

@Entity
@Table(name = "HoraAula")
public class HoraAula extends ModelEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * *****************************************************************************************************************
	 * ************************************************** Atributos ****************************************************
	 * *****************************************************************************************************************
	 */

	private Date horaInicio;
	private Date horaFinal;
	private Aula aula;

	/*
	 * *****************************************************************************************************************
	 * **************************************************** Gets e Sets ************************************************
	 * *****************************************************************************************************************
	 */
	
	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(Date horaFinal) {
		this.horaFinal = horaFinal;
	}

	@JoinColumn(name = "aula")
	@OneToOne(fetch = FetchType.LAZY)
	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	/*
	 * *****************************************************************************************************************
	 * ***************************************************** Metodos ***************************************************
	 * *****************************************************************************************************************
	 */
	
	public List<HoraAula> gerarHoraAulas(Aula aula, Date horaInicio, Date horaFinal){
		return new ArrayList<HoraAula>();
	}
	
}
