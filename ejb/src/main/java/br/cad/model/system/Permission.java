package br.cad.model.system;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.cad.model.ModelEntity;

/**
 * 
 * @author WilliamRodrigues <br>
 *         {@link william.rodrigues@live.fae.edu}
 * 
 */
@Entity
@Table(name = "Permissao")
public class Permission extends ModelEntity implements Serializable {
	/**
	 * SerialVersion
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * *****************************************************************************************************************
	 * ************************************************** Atributos ****************************************************
	 * *****************************************************************************************************************
	 */

	private Action action;
	private Resource resource;

	/*
	 * ******************************************************************************************************************
	 * **************************************************** Gets e Sets *************************************************
	 * ******************************************************************************************************************
	 */

	@JoinColumn(name = "idAction")
	@ManyToOne(fetch = FetchType.LAZY)
	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	@JoinColumn(name="idResource")
	@ManyToOne(fetch=FetchType.LAZY)
	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Metodos *****************************************************
	 * *******************************************************************************************************************
	 */

}
