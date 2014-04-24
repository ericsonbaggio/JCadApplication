package br.cad.model.academico;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.cad.model.ModelEntity;
import br.cad.model.pessoa.Aluno;
import br.cad.util.DataSistema;

@Entity
@Table(name = "Comentario")
public class Comentario extends ModelEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date dataCriacao;
	private String comentario;
	private Aluno aluno;
	private Aula aula;

	/*
	 * *****************************************************************************************************************
	 * **************************************************** Construtor *************************************************
	 * *****************************************************************************************************************
	 */

	public Comentario() {
		this.dataCriacao = DataSistema.getDataCorrenteTimestamp();
	}

	/*
	 * ******************************************************************************************************************
	 * **************************************************** Gets e Sets *************************************************
	 * ******************************************************************************************************************
	 */

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	
	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@JoinColumn(name = "aluno")
	@NotNull(message = "Aluno requerido.")
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@JoinColumn(name = "aula")
	@NotNull(message = "Aula requerida.")
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

}
