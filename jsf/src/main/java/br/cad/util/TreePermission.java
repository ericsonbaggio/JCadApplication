package br.cad.util;

import java.io.Serializable;

public class TreePermission implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private Long resource;
	private Long action;

	public TreePermission(String name, Long resource, Long action) {
		super();
		this.name = name;
		this.resource = resource;
		this.action = action;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getResource() {
		return resource;
	}

	public void setResource(Long resource) {
		this.resource = resource;
	}

	public Long getAction() {
		return action;
	}

	public void setAction(Long action) {
		this.action = action;
	}

}
