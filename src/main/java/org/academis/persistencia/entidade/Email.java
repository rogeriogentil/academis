package org.academis.persistencia.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "email")
public class Email implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;
	
	@NotNull
	@Column(nullable = false, unique = true)
	private String endereco;
		
	@ManyToOne
	private Pessoa pessoa;
}
