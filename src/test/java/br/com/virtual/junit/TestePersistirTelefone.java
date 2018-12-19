package br.com.virtual.junit;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.virtual.model.Telefone;
import br.com.virtual.util.EntityManagerUtil;

public class TestePersistirTelefone {

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
			Telefone telefone = new Telefone();
			telefone.setDdd("27");
			telefone.setNumero("9999-88887");
			em.getTransaction().begin();
			em.persist(telefone); 
			em.getTransaction().commit();
		} catch (Exception e) {
			exception = true;
			e.printStackTrace();
		}

		assertEquals(false, exception);

	}

}
