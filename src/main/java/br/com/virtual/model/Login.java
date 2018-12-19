package br.com.virtual.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "Login")
public class Login implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq_login", sequenceName = "seq_login_id", allocationSize = 1)
	@GeneratedValue(generator = "seq_login", strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull(message = "O nome nao pode ser nulo")
	@NotBlank(message = "O nome nao pode estar em branco")
	@Length(max = 10, message = "O nome nao pode ter mais de {max} caracteres")
	@Column(name = "Nome", length = 10, nullable = false)
	private String login;
	@NotNull(message = "A senha nao pode ser nulo")
	@NotBlank(message = "A senha nao pode estar em branco")
	@Length(max = 10, message = "A senha nao pode ter mais de {max} caracteres")
	@Column(name = "Senha", length = 10, nullable = false)
	private String senha;
	@OneToOne
	private Usuario usuario;

	public Login() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
		Login other = (Login) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return id + login + senha + usuario;
	}

}
