package br.cad.model.academico;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.cad.model.ModelEntity;
import br.cad.util.DataSistema;

@Entity
@Table(name = "Ementa")
public class Ementa extends ModelEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * *****************************************************************************************************************
	 * ************************************************** Atributos ****************************************************
	 * *****************************************************************************************************************
	 */
	
	private Date dataCriacao;
	private Date dataAtualizacao = DataSistema.getDataCorrenteTimestamp();
	private String arquivo;

	/*
	 * *****************************************************************************************************************
	 * **************************************************** Construtor *************************************************
	 * *****************************************************************************************************************
	 */

	public Ementa() {
		this.dataCriacao = DataSistema.getDataCorrenteTimestamp();
	}
	
	/*
	 * ******************************************************************************************************************
	 * **************************************************** Gets e Sets *************************************************
	 * ******************************************************************************************************************
	 */

	public String getArquivo() {
		return arquivo;
	}

	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	/*
	 * *******************************************************************************************************************
	 * ***************************************************** Metodos *****************************************************
	 * *******************************************************************************************************************
	 */

}
