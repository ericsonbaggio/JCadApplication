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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import br.cad.model.ModelEntity;

/**
 * 
 * @author WilliamRodrigues <br> {@link william.rodrigues@live.fae.edu}
 *
 */
@Entity
@Table(name = "Acao")
public class Action extends ModelEntity implements Serializable {
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
	private String code;
	private String icon;
	private String classColor;
	private String method;
	private String updateComponent;
	private TypeComponet typeComponet;
	
	private List<ActionParameters> params = new ArrayList<ActionParameters>();
	private List<Resource> resources = new ArrayList<Resource>();

	/*
	 *******************************************************************************************************************
	 ***************************************************** Gets e Sets *************************************************
	 *******************************************************************************************************************
	 */
	@Column(length = 50)
	@Size(min = 3, max = 50, message = "O Nome da Ação deve ter entre 3 à 50 caracteres!")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Column(length = 25)
	@Size(min = 3, max = 25, message = "O Código da Ação deve ter entre 3 à 25 caracteres!")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(length = 25)
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Column(length = 25)
	public String getClassColor() {
		return classColor;
	}

	public void setClassColor(String classColor) {
		this.classColor = classColor;
	}

	@Column(length = 150)
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	@Column(length = 25)
	public String getUpdateComponent() {
		return updateComponent;
	}

	public void setUpdateComponent(String updateComponent) {
		this.updateComponent = updateComponent;
	}
	
	@Column(columnDefinition = "int")
	public TypeComponet getTypeComponet() {
		return typeComponet;
	}

	public void setTypeComponet(TypeComponet typeComponet) {
		this.typeComponet = typeComponet;
	}

	@JoinColumn(name="idAction")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<ActionParameters> getParams() {
		return params;
	}

	public void setParams(List<ActionParameters> params) {
		this.params = params;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "ActionResource",
			joinColumns = { @JoinColumn(name = "idAction", referencedColumnName = "id") },
			inverseJoinColumns = { @JoinColumn(name = "idResource", referencedColumnName = "id") })
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
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj instanceof Action) {
			Action that = (Action) obj;
			if (that.getId() != null)
				return that.getId().equals(this.getId());
		}
		return false;
	}
}
