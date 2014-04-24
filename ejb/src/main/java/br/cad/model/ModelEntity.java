package br.cad.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Classe base para modelos de negócio Implementa Mapeamento para Id utilizando
 * a estratégia Identity Implementa os métodos toString, clone e equals.
 * 
 * @author WilliamRodrigues
 * 
 */
@MappedSuperclass
public class ModelEntity implements Model, Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	@Id
	@Column(columnDefinition="int")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;

		final ModelEntity other = (ModelEntity) obj;
		if (getId() == null || other.getId() == null)
			return super.equals(obj);

		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		if (id != null)
			return id.toString() + ":" + getClass().getName();
		return super.toString();
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
