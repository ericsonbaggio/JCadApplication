package br.cad.model.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.cad.model.ModelEntity;

/**
 * 
 * @author WilliamRodrigues
 * 
 */

@Entity
@Table(name = "Recurso")
public class Resource extends ModelEntity implements Serializable {
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
	private String locationOfFiles;
	private String controllerBean;
	private String objectClass;
	private String icon;
	private Domain domain;
	private String indexPage;
	private List<Action> actions = new ArrayList<Action>();
	private List<ResourceFile> files = new ArrayList<ResourceFile>();

	/*
	 *******************************************************************************************************************
	 ***************************************************** Gets e Sets *************************************************
	 *******************************************************************************************************************
	 */
	
	@Column(length = 50)
	@Size(min = 3, max = 50, message = "O Nome do recurso deve ter entre 3 à 50 caracteres!")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(length = 250)
	public String getLocationOfFiles() {
		return locationOfFiles;
	}

	public void setLocationOfFiles(String locationOfFiles) {
		this.locationOfFiles = locationOfFiles;
	}

	@Column(length = 100)
	public String getControllerBean() {
		return controllerBean;
	}

	public void setControllerBean(String controllerBean) {
		this.controllerBean = controllerBean;
	}

	@Column(length = 75)
	public String getObjectClass() {
		return objectClass;
	}

	public void setObjectClass(String objectClass) {
		this.objectClass = objectClass;
	}

	@Column(length = 25)
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@JoinColumn(name="idDomain")
	@ManyToOne(fetch=FetchType.LAZY)
	@NotNull(message = "Selecione um domínio!")
	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	@Column(length = 25)
	public String getIndexPage() {
		return indexPage;
	}

	public void setIndexPage(String indexPage) {
		this.indexPage = indexPage;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "ActionResource",
			joinColumns = { @JoinColumn(name = "idResource", referencedColumnName = "id") },
			inverseJoinColumns = { @JoinColumn(name = "idAction", referencedColumnName = "id") })
	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	@JoinColumn(name = "idResource")
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	public List<ResourceFile> getFiles() {
		return files;
	}

	public void setFiles(List<ResourceFile> files) {
		this.files = files;
	}

	/*
	 ********************************************************************************************************************
	 ****************************************************** Metodos *****************************************************
	 ********************************************************************************************************************
	 */

}
