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
@Table(name = "pais")
@NamedQueries({
	@NamedQuery(name = "Pais.obterTodos", query = "SELECT p FROM Pais p"),
	@NamedQuery(name = "Pais.obterPorId", query = "SELECT p FROM Pais p WHERE p.id = id")
})
public class Pais implements Serializable {

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
	
	@NotNull
	@Column(name = "denominacao_nacionalidade")
	private String denominacaoDeNacionalidade;
	
	@Column(length = 2)
	private String ddi;
	
	@OneToMany(mappedBy = "pais", fetch = FetchType.LAZY)
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

	public String getDenominacaoDeNacionalidade() {
		return denominacaoDeNacionalidade;
	}

	public void setDenominacaoDeNacionalidade(String denominacaoDeNacionalidade) {
		this.denominacaoDeNacionalidade = denominacaoDeNacionalidade;
	}

	public String getDdi() {
		return ddi;
	}

	public void setDdi(String ddi) {
		this.ddi = ddi;
	}

	public Collection<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(Collection<Cidade> cidades) {
		this.cidades = cidades;
	}
}
