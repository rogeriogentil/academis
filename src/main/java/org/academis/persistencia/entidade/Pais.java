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
@Table(name = "pais")
public class Pais implements Serializable {

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
	
	@NotNull
	@Column(name = "denominacao_nacionalidade")
	private String denominacaoDeNacionalidade;
	
	@Column(length = 2)
	private String ddi;
	
	@OneToMany(mappedBy = "pais", fetch = FetchType.LAZY)
	private Collection<Cidade> cidades;
}
