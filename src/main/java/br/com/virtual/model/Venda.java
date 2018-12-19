package br.com.virtual.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Venda")
public class Venda implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "seq_venda", sequenceName = "seq_venda_id", allocationSize = 1)
	@GeneratedValue(generator = "seq_venda", strategy = GenerationType.IDENTITY)
	private Integer id;
	
	//Ainda irei prosseguir daqui.....

}
