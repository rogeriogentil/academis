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
import javax.persistence.Version;

import org.academis.persistencia.tipo.TipoNacionalidade;

@Entity
@Table(name = "nacionalidade")
public class Nacionalidade implements Serializable {

	private static final long serialVersionUID = 1L;
		
	@EmbeddedId
	private NacionalidadePK pk;

	@Version
	private long version;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo", length = 12, nullable = false)
	private TipoNacionalidade tipo;
	
	@JoinColumn(name = "pessoa_id", referencedColumnName = "id", insertable = false, updatable = false)
	@ManyToOne
	private Pessoa pessoa;
	
	@JoinColumn(name = "pais_id", referencedColumnName = "id", insertable = false, updatable = false)
	@ManyToOne
	private Pais pais;

	public NacionalidadePK getPk() {
		return pk;
	}

	public void setPk(NacionalidadePK pk) {
		this.pk = pk;		
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public TipoNacionalidade getTipo() {
		return tipo;
	}

	public void setTipo(TipoNacionalidade tipo) {
		this.tipo = tipo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
}
