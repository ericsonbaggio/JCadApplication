package br.cad.model.academico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import br.cad.model.ModelEntity;
import br.cad.util.DataSistema;

@Entity
@Table(name = "MatrizCurricular")
public class MatrizCurricular extends ModelEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * *****************************************************************************************************************
	 * ************************************************** Atributos ****************************************************
	 * *****************************************************************************************************************
	 */

	private Date dataCriacao;
	private Date dataAtualizacao = DataSistema.getDataCorrenteTimestamp();
	private Curso curso;
	private Integer periodo;
	private TipoPeriodo tipoPeriodo;
	private List<CurriculoDisciplina> curriculoDisciplina = new ArrayList<CurriculoDisciplina>();

	/*
	 * *****************************************************************************************************************
	 * **************************************************** Construtor *************************************************
	 * *****************************************************************************************************************
	 */

	public MatrizCurricular() {
		this.dataCriacao = DataSistema.getDataCorrenteTimestamp();
	}

	/*
	 * *****************************************************************************************************************
	 * **************************************************** Gets e Sets ************************************************
	 * *****************************************************************************************************************
	 */

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	@JoinColumn(name = "curso")
	@NotNull(message = "Curso requerido.")
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Range(max = 2)
	public Integer getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}

	@NotNull
	@Column(length = 25)
	@Enumerated(EnumType.STRING)
	public TipoPeriodo getTipoPeriodo() {
		return tipoPeriodo;
	}

	public void setTipoPeriodo(TipoPeriodo tipoPeriodo) {
		this.tipoPeriodo = tipoPeriodo;
	}

	@JoinColumn(name = "matrizCurricular")
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<CurriculoDisciplina> getCurriculoDisciplina() {
		return curriculoDisciplina;
	}

	public void setCurriculoDisciplina(List<CurriculoDisciplina> curriculoDisciplina) {
		this.curriculoDisciplina = curriculoDisciplina;
	}

	/*
	 * *****************************************************************************************************************
	 * ***************************************************** Metodos ***************************************************
	 * *****************************************************************************************************************
	 */

}
