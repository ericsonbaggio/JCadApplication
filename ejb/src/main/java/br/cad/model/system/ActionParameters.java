package br.cad.model.system;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.cad.model.ModelEntity;

/**
 * 
 * @author WilliamRodrigues <br> {@link william.rodrigues@live.fae.edu}
 *
 */
@Entity
@Table(name = "AcaoParametros")
public class ActionParameters extends ModelEntity implements Serializable {
	/**
	 * SerialVersion
	 */
	private static final long serialVersionUID = 1L;

	/*
	 *******************************************************************************************************************
	 *************************************************** CONSTRUTORES **************************************************
	 *******************************************************************************************************************
	 */
	
	public ActionParameters() {
		
	}
	
	public ActionParameters(String param) {
		this.param = param;
	}
	
	/* 
	 ******************************************************************************************************************
	 *************************************************** Atributos ****************************************************
	 ******************************************************************************************************************
	 */
	private String param;
	private Action action;

	/*
	 *******************************************************************************************************************
	 ***************************************************** Gets e Sets *************************************************
	 *******************************************************************************************************************
	 */
	
	@NotNull
	@Column(length = 500)	
	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	
	@JoinColumn(name="idAction")
	@ManyToOne(fetch = FetchType.LAZY)
	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}
	
	/*
	 ********************************************************************************************************************
	 ****************************************************** Metodos *****************************************************
	 ********************************************************************************************************************
	 */
	
}
