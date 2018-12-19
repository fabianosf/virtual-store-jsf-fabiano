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
@Table(name="Endereco")
public class Endereco implements Serializable {	 
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="seq_endereco", sequenceName="seq_endereco_id", allocationSize=1)
	@GeneratedValue(generator = "seq_endereco", strategy=GenerationType.IDENTITY) 
	private Integer id;	
	@NotNull(message = "O logradouro nao pode ser nulo")
	@NotBlank(message= "O logradouro nao pode estar em branco")
	@Length(max=150, message="O logradouro nao pode ter mais de {max} caracteres")
	@Column(name="Logradouro", length=150, nullable = false)
	private String logradouro;
	@NotNull(message = "O numero nao pode ser nulo")
	@NotBlank(message= "O numero nao pode estar em branco")
	@Length(max=3, message="O numero nao pode ter mais de {max} caracteres")
	@Column(name="Numero", length=3, nullable = false)
	private String numero;
	@NotNull(message = "O bairro nao pode ser nulo")
	@NotBlank(message= "O bairro nao pode estar em branco")
	@Length(max=50, message="O logradouro nao pode ter mais de {max} caracteres")
	@Column(name="Bairro", length=50, nullable = false)
	private String bairro;	 
	@NotNull(message = "O cep nao pode ser nulo")
	@NotBlank(message= "O cep nao pode estar em branco")
	@Length(max=9, message="O cep nao pode ter mais de {max} caracteres")
	@Column(name="Cep", length=9, nullable = false)
	private String cep;
	@NotNull(message = "O complemento nao pode ser nulo")
	@NotBlank(message= "O complemento estar em branco")
	@Length(max=30, message="O complemento nao pode ter mais de {max} caracteres")
	@Column(name="Complemento", length=30, nullable = false)
	private String complemento;
	@NotNull(message = "A referencia nao pode ser nulo")
	@NotBlank(message= "A referencia pode estar em branco")
	@Length(max=30, message="A referencia nao pode ter mais de {max} caracteres")
	@Column(name="Referencia", length=30, nullable = false)
	private String referencia;
	@Column(name="uf", length = 2, nullable = false) 
	private String uf;
	@OneToOne
	private Usuario usuario;
	
	public Endereco() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	 

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
		 

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
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
		Endereco other = (Endereco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", logradouro=" + logradouro + ", numero=" + numero + ", bairro=" + bairro
				+ ", cep=" + cep + ", complemento=" + complemento + ", referencia=" + referencia + ", uf=" + uf + "]";
	}

	  
	
	
	
}







