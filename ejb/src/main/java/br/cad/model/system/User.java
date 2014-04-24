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
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import br.cad.util.MD5;
import br.cad.model.ModelEntity;

/**
 * 
 * @author WilliamRodrigues
 */

@Entity
@Table(name = "Usuario")
public class User extends ModelEntity implements Serializable {
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
	private String email;
	private String keyUser;
	private String password;
	private Boolean active;
	private List<Group> groups = new ArrayList<Group>();

	/*
	 *******************************************************************************************************************
	 ***************************************************** Gets e Sets *************************************************
	 *******************************************************************************************************************
	 */
	@Column(length = 75)
	@Size(min = 10, max = 75, message = "O Nome Usuario deve ter entre 10 à 75 caracteres!")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotNull
	@Column(length = 25, unique = true, nullable = false)
	@Size(min = 4, max = 25, message = "O Login (keyUser) deve ter entre 4 à 16 caracteres!")
	public String getKeyUser() {
		return keyUser;
	}

	public void setKeyUser(String keyUser) {
		this.keyUser = keyUser;
	}

	@Column(length = 50)
	@Email(message = "O e-mail deve ser válido!")
	@Size(min = 8, max = 50, message = "O Email deve ter entre 8 à 50 caracteres!")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length = 50)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPasswordKeyUser(String password) {
		if (password != null && password.trim().length() > 0)
			try {
				setPassword(MD5.encrypt(password));
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	@Transient
	@Size(min = 4, max = 16, message = "A senha deve ter entre 4 à 16 caracteres!")
	public String getPasswordKeyUser() {
		return null;
	}

	@NotNull
	@Column(columnDefinition = "int")
	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "UserGroup",
			joinColumns = { @JoinColumn(name = "idUser", referencedColumnName = "id") },
			inverseJoinColumns = { @JoinColumn(name = "idGroup", referencedColumnName = "id") })
	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
	
	/*
	 ********************************************************************************************************************
	 ****************************************************** Metodos *****************************************************
	 ********************************************************************************************************************
	 */
	
//	@Transient
//	public boolean isTemAcesso(String pagina, String cdAcao) {
//		for (Grupo grupo : getGrupos()) {
//			if (grupo.isTemAcesso(pagina, cdAcao)) {
//				return true;
//			}
//		}
//		return false;
//	}
//
	@Transient
	public boolean isPermittedAccess(String page) {
		for (Group group : groups) {
			if (group.isPermittedAccess(page)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Verifica se a chave key e valida de acordo com o atributo codigo
	 * 
	 * @return true se for valida e false caso contrario.
	 */
	@Transient
	public boolean checkValidKey(String key) {
		try {
			return key.equals(getUserKey());
		} catch (Exception e) {
		}
		return false;
	}

	/**
	 * Gera uma chave unica para o usuario. Utilizada para entrada automatica no sistema.
	 * 
	 * @return
	 */
	@Transient
	public String getUserKey() {
		try {
			char[] md5 = MD5.encrypt(keyUser.toLowerCase()).toLowerCase().toCharArray();
			changePosition(md5, 5, 4);
			changePosition(md5, 10, 2);
			changePosition(md5, 3, 12);
			changePosition(md5, 15, 7);
			changePosition(md5, 1, 8);
			changePosition(md5, 20, 8);
			changePosition(md5, 21, 3);
			changePosition(md5, 31, 6);
			changePosition(md5, 30, 28);
			changePosition(md5, 28, 18);
			changePosition(md5, 25, 13);
			return new String(md5);
		} catch (Exception e) {
		}
		return null;
	}

	private void changePosition(char[] ch, int p1, int p2) {
		char aux = ch[p1];
		ch[p1] = ch[p2];
		ch[p2] = aux;
	}
}
