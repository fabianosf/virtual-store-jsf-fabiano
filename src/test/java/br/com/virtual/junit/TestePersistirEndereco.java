package br.com.virtual.junit;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.virtual.model.Endereco;
import br.com.virtual.util.EntityManagerUtil;

public class TestePersistirEndereco {

	EntityManager em;

	@Before
	public void setUp() {
		em = EntityManagerUtil.getEntityManager();

	}

	@After
	public void tearDown() {
		em.close();
	}

	@Test
	public void test() {
		boolean exception = false;
		try {
			Endereco end = new Endereco();
			end.setLogradouro("Rua das Pedras");
			end.setNumero("45");
			end.setBairro("Campo Verde");
			end.setCep("23999-631");
			end.setComplemento("Casa de Madeira");
			end.setReferencia("Perto do Lago");
			end.setUf("RJ");
			em.getTransaction().begin();
			em.persist(end);
			em.getTransaction().commit();
		} catch (Exception e) {
			exception = true;
			e.printStackTrace();
		}

		assertEquals(false, exception);

	}

}
