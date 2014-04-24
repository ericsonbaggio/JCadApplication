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
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import br.cad.model.ModelEntity;

/**
 * 
 * @author WilliamRodrigues
 * 
 */

@Entity
@Table(name = "Grupo")
public class Group extends ModelEntity implements Serializable {
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
	private String description;
	private List<Permission> permissions = new ArrayList<Permission>();
	private List<User> users = new ArrayList<User>();

	/*
	 *******************************************************************************************************************
	 ***************************************************** Gets e Sets *************************************************
	 *******************************************************************************************************************
	 */
	@Column(length = 24)
	@Size(min = 4, max = 24, message = "O Grupo deve ter entre 4 à 24 caracteres!")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length = 250)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "UserGroup",
			joinColumns = { @JoinColumn(name = "idGroup", referencedColumnName = "id") },
			inverseJoinColumns = { @JoinColumn(name = "idUser", referencedColumnName = "id") })
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@JoinColumn(name = "idGroup")
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, orphanRemoval = true)
	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	/*
	 ********************************************************************************************************************
	 ****************************************************** Metodos *****************************************************
	 ********************************************************************************************************************
	 */
	
	@Transient
	public boolean isPermittedAccess(String page) {
		for (Permission p : permissions) {
			for(ResourceFile rf : p.getResource().getFiles()) {
				if(rf.getActionsOfPages().contains(p.getAction())) {
					if (page.contains(p.getResource().getLocationOfFiles() + rf.getPageURL())) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
