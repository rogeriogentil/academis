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
}
