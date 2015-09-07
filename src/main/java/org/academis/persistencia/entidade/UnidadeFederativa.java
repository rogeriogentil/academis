package org.academis.persistencia.entidade;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "unidade_federativa")
@NamedQueries({
	@NamedQuery(name = "UF.obterTodas", query = "SELECT uf FROM UnidadeFederativa uf"),
	@NamedQuery(name = "UF.obterPorId", query = "SELECT uf FROM UnidadeFederativa uf WHERE uf.id = id")
})
public class UnidadeFederativa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;
	
	@Version
	private long version;
	
	@NotNull
	@Column(nullable = false)
	private String nome;
	
	@NotNull
	@Size(min = 2, max = 2)
	@Column(length = 2, nullable = false, unique = true)
	private String sigla;
	
	@OneToMany(mappedBy = "uf", fetch = FetchType.LAZY)
	private Collection<Cidade> cidades;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Collection<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(Collection<Cidade> cidades) {
		this.cidades = cidades;
	}
}
