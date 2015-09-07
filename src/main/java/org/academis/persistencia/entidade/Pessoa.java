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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.academis.persistencia.tipo.Sexo;

@Entity
@Table(name = "pessoa")
@NamedQueries({
	@NamedQuery(name = "Pessoa.obterTodas", query = "SELECT p FROM Pessoa p"),
	@NamedQuery(name = "Pessoa.obterPorId", query = "SELECT p FROM Pessoa p WHERE p.id = id"),	
	@NamedQuery(name = "Pessoa.obterPorCPF", query = "SELECT p FROM Pessoa p WHERE p.cpf = cpf")
})
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;
	
	@Version
	private long version;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPassaporte() {
		return passaporte;
	}

	public void setPassaporte(String passaporte) {
		this.passaporte = passaporte;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Collection<Email> getEmails() {
		return emails;
	}

	public void setEmails(Collection<Email> emails) {
		this.emails = emails;
	}

	public Cidade getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(Cidade naturalidade) {
		this.naturalidade = naturalidade;
	}

	public Collection<Nacionalidade> getNacionalidades() {
		return nacionalidades;
	}

	public void setNacionalidades(Collection<Nacionalidade> nacionalidades) {
		this.nacionalidades = nacionalidades;
	}
}
