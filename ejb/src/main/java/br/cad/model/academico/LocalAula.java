package br.cad.model.academico;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import br.cad.model.ModelEntity;

@Entity
@Table(name = "LocalAula")
public class LocalAula extends ModelEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * *****************************************************************************************************************
	 * ************************************************** Atributos ****************************************************
	 * *****************************************************************************************************************
	 */

	private Integer capacidade;
	private String descricao;
	private TipoLocal tipoLocal;

	/*
	 * ******************************************************************************************************************
	 * **************************************************** Gets e Sets *************************************************
	 * ******************************************************************************************************************
	 */

	@Range(max = 5)
	public Integer getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}

	@Column(length = 25)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@NotNull
	@Column(length = 25)
	@Enumerated(EnumType.STRING)
	public TipoLocal getTipoLocal() {
		return tipoLocal;
	}

	public void setTipoLocal(TipoLocal tipoLocal) {
		this.tipoLocal = tipoLocal;
	}

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Metodos *****************************************************
	 * *******************************************************************************************************************
	 */

}
