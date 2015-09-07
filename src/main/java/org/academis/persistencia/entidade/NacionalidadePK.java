package org.academis.persistencia.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class NacionalidadePK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "pessoa_id")
	private long pessoaId;

	@Column(name = "pais_id")
	private long paisId;

	public long getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(long pessoaId) {
		this.pessoaId = pessoaId;
	}

	public long getPaisId() {
		return paisId;
	}

	public void setPaisId(long paisId) {
		this.paisId = paisId;
	}
}
