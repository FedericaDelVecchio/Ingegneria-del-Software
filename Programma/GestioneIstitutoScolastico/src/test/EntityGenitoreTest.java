package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import entity.EntityGenitore;
import database.DBGenitore;

class EntityGenitoreTest {
	@Test
	void testEntityGenitore() {
		EntityGenitore g = new EntityGenitore();
		assertNotNull(g);
	}

	@Test
	void testEntityGenitoreString() {
		EntityGenitore g = new EntityGenitore("genitore3");
		assertEquals("genitore3",g.getUsername());
	}

	@Test
	void testEntityGenitoreDBGenitore() {
		DBGenitore g = new DBGenitore("genitore3");
		EntityGenitore genitore = new EntityGenitore(g);
		assertEquals("genitore3",genitore.getUsername());
	}

	@Test
	void testCaricaFigli() {
		EntityGenitore g = new EntityGenitore("genitore3");
		g.caricaFigli();
		assertNotNull(g.getFigli());
	}

	@Test
	void testRegistraGenitore() {
		EntityGenitore g = new EntityGenitore();
		g.registraGenitore("genitore20", "password", "Mario", "Roma", "Napoli", "12/06/1981", "AFWIOE33444", 123456, "marioR@gmail.com");
		assertEquals("genitore20",g.getUsername());
		assertEquals("password",g.getPassword());
		assertEquals("Mario",g.getNome());
		assertEquals("Roma",g.getCognome());
		assertEquals("Napoli",g.getResidenza());
		assertEquals("12/06/1981",g.getNascita());
		assertEquals("AFWIOE33444",g.getCodiceFiscale());
		assertEquals(123456,g.getCellulare());
		assertEquals("marioR@gmail.com",g.getEmail());
	}

}
