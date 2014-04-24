package br.cad.model.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.cad.model.ModelEntity;

/**
 * 
 * @author Will
 * 
 */

@Entity
@Table(name = "Dominio")
public class Domain extends ModelEntity implements Serializable {
	/**
	 * SerialVersion
	 */
	private static final long serialVersionUID = 1L;

	/* 
	 ******************************************************************************************************************
	 *************************************************** Atributos ****************************************************
	 ******************************************************************************************************************
	 */
	private String name;
	private Integer orderObject;
	private String icon;
	private List<Domain> subDomains = new ArrayList<Domain>();
	private List<Resource> resources = new ArrayList<Resource>();

	/*
	 *******************************************************************************************************************
	 ***************************************************** Gets e Sets *************************************************
	 *******************************************************************************************************************
	 */
	@NotNull
	@Column(length = 75)
	@Size(min = 4, max = 75, message = "O Nome do Domónio deve ter entre 4 à 75 caracteres!")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getOrderObject() {
		return orderObject;
	}

	public void setOrderObject(Integer orderObject) {
		this.orderObject = orderObject;
	}

	@Column(length = 75)
	public String getIcone() {
		return icon;
	}

	public void setIcone(String icone) {
		this.icon = icone;
	}

	@JoinColumn(name = "idDomain")
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Domain> getSubDomains() {
		return subDomains;
	}

	public void setSubDomains(List<Domain> subDomains) {
		this.subDomains = subDomains;
	}

	@JoinColumn(name = "idDomain")
	@OneToMany(fetch = FetchType.LAZY)
	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}

	/*
	 ********************************************************************************************************************
	 ****************************************************** Metodos *****************************************************
	 ********************************************************************************************************************
	 */
}
