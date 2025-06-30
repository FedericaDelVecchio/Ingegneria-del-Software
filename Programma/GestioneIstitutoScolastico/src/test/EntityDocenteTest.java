package test;

import static org.junit.jupiter.api.Assertions.*;
import entity.EntityDocente;
import entity.EntityGenitore;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import database.DBDocente;

class EntityDocenteTest {
	@Test
	void testEntityDocente() {
		EntityDocente d = new EntityDocente();
		assertNotNull(d);
	}

	@Test
	void testEntityDocenteString() {
		EntityDocente d = new EntityDocente("docente3");
		assertEquals("docente3",d.getUsername());
	}

	@Test
	void testEntityDocenteDBDocente() {
		DBDocente d = new DBDocente("docente3");
		EntityDocente docente = new EntityDocente(d);
		assertEquals("docente3",docente.getUsername());
	}

	@Test
	void testCaricaInsegna() {
		EntityDocente d = new EntityDocente("docente3");
		d.caricaInsegna();
		assertNotNull(d.getInsegna());
	}

	@Test
	void testRegistraDocente() {
		EntityDocente d = new EntityDocente();
		d.registraDocente("docente20", "password", "Mario", "Roma", "Napoli", "12/06/1981", "AGERHTYJHJ", 123456, "marioR@gmail.com");
		assertEquals("docente20",d.getUsername());
		assertEquals("password",d.getPassword());
		assertEquals("Mario",d.getNome());
		assertEquals("Roma",d.getCognome());
		assertEquals("Napoli",d.getResidenza());
		assertEquals("12/06/1981",d.getNascita());
		assertEquals("AGERHTYJHJ",d.getCodiceFiscale());
		assertEquals(123456,d.getCellulare());
		assertEquals("marioR@gmail.com",d.getEmail());
	}

}
