package org.academis.persistencia.entidade;

public enum TipoNacionalidade {

	NATO("Nato"), 
	NATURALIZADO("Naturalizado"), 
	EQUIPARADO("Equiparado");

	private final String tipo;

	private TipoNacionalidade(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}
}
