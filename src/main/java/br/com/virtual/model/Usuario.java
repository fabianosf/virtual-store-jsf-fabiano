package br.com.virtual.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario_id", allocationSize = 1)
	@GeneratedValue(generator = "seq_usuario", strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull(message = "O nome nao pode ser nulo")
	@NotBlank(message = "O nome nao pode estar em branco")
	@Length(max = 50, message = "O nome nao pode ter mais de {max} caracteres")
	@Column(name = "Nome", length = 50, nullable = false)
	private String nome;
	@Lob
	@Column(name = "Foto", nullable = false)
	private String fotoUrl;
	@NotNull(message = "A naturalidade nao pode ser nulo")
	@NotBlank(message = "A naturalidade nao pode estar em branco")
	@Length(max = 2, message = "A naturalidade nao pode ter mais de {max} caracteres")
	@Column(name = "Naturalidade", length = 2, nullable = false)
	private String naturalidade;
	@NotNull(message = "O CPF nao pode ser nulo")
	@NotBlank(message = "O CPF nao pode estar em branco")
	@Length(max = 15, message = "O CPF nao pode ter mais de {max} caracteres")
	@CPF(message = "O CPF deve ser valido")
	@Column(name = "CPF", length = 15, nullable = false)
	private String cpf;
	@Column(name="Status")
	private boolean status;
	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
	private Login login;
	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
	private Endereco endereco;
	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
	private Telefone telefone;

	public Usuario() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFotoUrl() {
		return fotoUrl;
	}

	public void setFotoUrl(String fotoUrl) {
		this.fotoUrl = fotoUrl;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return id + nome + fotoUrl + naturalidade + cpf + status + login + endereco;
	}

}
