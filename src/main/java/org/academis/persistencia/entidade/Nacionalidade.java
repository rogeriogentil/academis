package org.academis.persistencia.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "nacionalidade")
public class Nacionalidade implements Serializable {

	private static final long serialVersionUID = 1L;
		
	@EmbeddedId
	private NacionalidadePK pk;	

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo", length = 12, nullable = false)
	private TipoNacionalidade tipo;
	
	@JoinColumn(name = "pessoa_id", referencedColumnName = "id", insertable = false, updatable = false)
	@ManyToOne
	private Pessoa pessoa;
	
	@JoinColumn(name = "pais_id", referencedColumnName = "id", insertable = false, updatable = false)
	@ManyToOne
	private Pais pais;
	
}
