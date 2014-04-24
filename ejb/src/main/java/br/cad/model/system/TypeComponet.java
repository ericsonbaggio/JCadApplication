package br.cad.model.system;

import java.util.Arrays;
import java.util.List;

public enum TypeComponet {
	
	LINK(0, "<a href />"),
	HLINK(1, "<h:link />"),
	HCOMMANDLINK(2, "<h:commandLink />"),
	PCOMMANDLINK(3, "<p:commandLink />"),
	HBUTTON(4, "<h:button />"),
	PBUTTON(5, "<p:button />"),
	HCOMMANDBUTTON(6, "<h:commandButton />"),
	PCOMMANDBUTTON(7, "<p:commandButton />");

	private TypeComponet(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	private Integer id;
	private String nome;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static TypeComponet getByTipo(String tipo) {
		for (TypeComponet t : values()) {
			if (t.nome.equals(tipo))
				return t;
		}
		return null;
	}
	
	public static List<TypeComponet> getList() {
		return Arrays.asList(TypeComponet.values());
	}
}
