package br.com.virtual.junit;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.virtual.model.Login;
import br.com.virtual.util.EntityManagerUtil;

public class TestePersistirLogin {

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
			Login login = new Login();
			login.setLogin("mariafs");
			login.setSenha("123");			 
			em.getTransaction().begin();
			em.persist(login);
			em.getTransaction().commit();
		} catch (Exception e) {
			exception = true;
			e.printStackTrace();
		}

		assertEquals(false, exception);

	}

}
