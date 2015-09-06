package org.academis.persistencia.entidade;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.academis.persistencia.tipo.Sexo;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;

	@NotNull
	@Column(nullable = false)
	private String nome;

	@Column(length = 11, unique = true)
	private String cpf;

	@Column(unique = true)
	private String passaporte;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento")
	private Date dataDeNascimento;

	@Enumerated(EnumType.STRING)
	@Column(length = 1)
	private Sexo sexo;

	@OneToMany(mappedBy = "pessoa")
	private Collection<Email> emails;

	@ManyToOne
	private Cidade naturalidade;
	
	@OneToMany(mappedBy = "pessoa")
	private Collection<Nacionalidade> nacionalidades;
}
