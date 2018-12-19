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
@Table(name = "Telefone")
public class Telefone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq_telefone", sequenceName = "seq_telefone_id", allocationSize = 1)
	@GeneratedValue(generator = "seq_telefone", strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull(message = "O ddd nao pode ser nulo")
	@NotBlank(message = "O ddd nao pode estar em branco")
	@Length(max = 2, message = "O ddd nao pode ter mais de {max} caracteres")
	@Column(name = "DDD", length = 2, nullable = false)
	private String ddd;
	@NotNull(message = "O numero nao pode ser nulo")
	@NotBlank(message = "O numero nao pode estar em branco")
	@Length(max = 12, message = "O numero nao pode ter mais de {max} caracteres")
	@Column(name = "Logradouro", length = 12, nullable = false)
	private String numero;
	@OneToOne
	private Usuario usuario;

	public Telefone() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
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
		Telefone other = (Telefone) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return id + ddd + numero;
	}

}
