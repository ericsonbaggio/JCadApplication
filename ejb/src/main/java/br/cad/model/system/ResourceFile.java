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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.cad.model.ModelEntity;

/**
 * 
 * @author WilliamRodrigues
 * 
 */

@Entity
@Table(name = "ResourceFile")
public class ResourceFile extends ModelEntity implements Serializable {
	/**
	 * SerialVersion
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * *****************************************************************************************************************
	 * ************************************************** Atributos ****************************************************
	 * *****************************************************************************************************************
	 */
	
	private String file;
	private String codeFile;
	private String pageURL;
	private Resource resource;
	private List<Action> actionsOfPages = new ArrayList<Action>();

	/*
	 * ******************************************************************************************************************
	 * **************************************************** Gets e Sets *************************************************
	 * ******************************************************************************************************************
	 */

	@Column(length = 100)
	@NotNull(message = "O arquivo deve ser preencido.")
	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	@Column(length = 25)
	public String getCodeFile() {
		return codeFile;
	}

	public void setCodeFile(String codeFile) {
		this.codeFile = codeFile;
	}

	@Column(length = 20)
	@NotNull(message = "A página deve ser preencida.")
	public String getPageURL() {
		return pageURL;
	}

	public void setPageURL(String pageURL) {
		this.pageURL = pageURL;
	}

	@JoinColumn(name="idResource")
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.MERGE)
	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	@ManyToMany(fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "ActionsFile",
		joinColumns = { @JoinColumn(name = "idFile", referencedColumnName = "id") },
		inverseJoinColumns = { @JoinColumn(name = "idAction", referencedColumnName = "id")})
	public List<Action> getActionsOfPages() {
		return actionsOfPages;
	}

	public void setActionsOfPages(List<Action> actionsOfPages) {
		this.actionsOfPages = actionsOfPages;
	}

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Metodos *****************************************************
	 * *******************************************************************************************************************
	 */

}
