package br.cad.model.pessoa;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.cad.model.ModelEntity;
import br.cad.model.system.User;

/**
 * Classe responsavel pelo papel de cada pessoa tipo Aluno, professor e etc...
 * 
 * @author WilliamRodrigues <br>
 *         william.rodrigues@live.fae.edu
 * 
 */
@Entity
@Table(name = "PessoaPapel")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class PessoaPapel extends ModelEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * *****************************************************************************************************************
	 * ************************************************** Atributos ****************************************************
	 * *****************************************************************************************************************
	 */
	
	private String nomeCompleto;
	private String nomeAbreviado;
	private Boolean sitPessoa;
	
	/**
	 * Usuario do Sistema
	 */
	private User usuario;

	/*
	 * ******************************************************************************************************************
	 * **************************************************** Gets e Sets *************************************************
	 * ******************************************************************************************************************
	 */

	@NotNull
	@Column(length = 255)
	@Size(min = 5, max = 255, message = "")
	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	@Column(length = 75)
	@Size(min = 3, max = 75, message = "")
	public String getNomeAbreviado() {
		return nomeAbreviado;
	}

	public void setNomeAbreviado(String nomeAbreviado) {
		this.nomeAbreviado = nomeAbreviado;
	}

	@Column(columnDefinition = "int default 1")
	public Boolean getSitPessoa() {
		return sitPessoa;
	}

	public void setSitPessoa(Boolean sitPessoa) {
		this.sitPessoa = sitPessoa;
	}

	@JoinColumn(name = "usuario")
	@NotNull(message = "Usuário deve ser preenchido")
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Metodos *****************************************************
	 * *******************************************************************************************************************
	 */
}
