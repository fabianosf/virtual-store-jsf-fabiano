package br.com.virtual.junit;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.virtual.model.Endereco;
import br.com.virtual.model.Login;
import br.com.virtual.model.Telefone;
import br.com.virtual.model.Usuario;
import br.com.virtual.util.EntityManagerUtil;

public class TestePersistirUsuario {

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
			Endereco end = em.find(Endereco.class, 1);
			Telefone tel = em.find(Telefone.class, 1);
			Login log = em.find(Login.class, 1);
			Usuario usuario = new Usuario();
			usuario.setNome("Maria Flores Silva");
			usuario.setFotoUrl("Foto da Maria");
			usuario.setNaturalidade("RJ");
			usuario.setCpf("705.449.380-03");
			usuario.setStatus(true);			 
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();
		} catch (Exception e) {
			exception = true;
			e.printStackTrace();
		}

		assertEquals(false, exception);

	}

}
