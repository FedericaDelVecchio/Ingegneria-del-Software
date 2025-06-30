package test;

import static org.junit.jupiter.api.Assertions.*;
import entity.EntityAlunno;
import database.DBAlunno;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.EntityDocente;

class EntityAlunnnoTest {
	@Test
	void testEntityAlunno() {
		EntityAlunno a = new EntityAlunno();
		assertNotNull(a);
	}

	@Test
	void testEntityAlunnoString() {
		EntityAlunno a = new EntityAlunno("alunno5");
		assertEquals("alunno5",a.getUsername());
		assertNotNull(a.getClasse());
	}

	@Test
	void testEntityAlunnoDBAlunno() {
		DBAlunno alunno = new DBAlunno("alunno5");
		EntityAlunno a = new EntityAlunno(alunno);
		assertEquals("alunno5",a.getUsername());
		assertNotNull(a.getClasse());
	}

	@Test
	void testCaricaGenitori() {
		EntityAlunno a = new EntityAlunno("alunno5");
		a.caricaGenitori();
		assertNotNull(a.getGenitori());
	}

	@Test
	void testRegistraAlunno() {
		EntityAlunno a = new EntityAlunno();
		a.registraAlunno("alunno19", "password", "Mario", "Roma", "Napoli", "12/06/1981", "G35Y3HGR", 123456, "marioR@gmail.com");
		assertEquals("alunno19",a.getUsername());
		assertEquals("password",a.getPassword());
		assertEquals("Mario",a.getNome());
		assertEquals("Roma",a.getCognome());
		assertEquals("Napoli",a.getResidenza());
		assertEquals("12/06/1981",a.getNascita());
		assertEquals("G35Y3HGR",a.getCodiceFiscale());
		assertEquals(123456,a.getCellulare());
		assertEquals("marioR@gmail.com",a.getEmail());
	}

}
