package org.academis.persistencia.entidade;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "unidade_federativa")
public class UnidadeFederativa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;
	
	@NotNull
	@Column(nullable = false)
	private String nome;
	
	@NotNull
	@Size(min = 2, max = 2)
	@Column(length = 2, nullable = false, unique = true)
	private String sigla;
	
	@OneToMany(mappedBy = "uf", fetch = FetchType.LAZY)
	private Collection<Cidade> cidades;
}
