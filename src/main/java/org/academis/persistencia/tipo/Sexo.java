package org.academis.persistencia.tipo;

public enum Sexo {

	F("Feminino"),
	M("Masculino");
	
	public final String tipo;

	private Sexo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}
}
