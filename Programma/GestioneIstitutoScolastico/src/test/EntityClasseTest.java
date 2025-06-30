package test;

import static org.junit.jupiter.api.Assertions.*;
import entity.EntityClasse;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import database.DBClasse;

class EntityClasseTest {
	@Test
	void testEntityClasse() {
		EntityClasse classe = new EntityClasse();
		assertNotNull(classe);
	}

	@Test
	void testEntityClasseStringString() {
		EntityClasse classe = new EntityClasse("I","A");
		assertEquals("I",classe.getAnno());
		assertEquals("A",classe.getSezione());
		
	}

	@Test
	void testEntityClasseDBClasse() {
		DBClasse c = new DBClasse("I","A");
		EntityClasse classe = new EntityClasse(c);
		assertEquals("I",classe.getAnno());
		assertEquals("A",classe.getSezione());
	}

	@Test
	void testEntityClasseEntityClasse() {
		EntityClasse c = new EntityClasse("I","A");
		EntityClasse classe = new EntityClasse(c);
		assertEquals("I",classe.getAnno());
		assertEquals("A",classe.getSezione());
	}

	@Test
	void testCaricaAlunni() {
		EntityClasse c = new EntityClasse("I","A");
		c.caricaAlunni();
		assertNotNull(c.getAlunni());
	}

	@Test
	void testCaricaRegistroElettronico() {
		EntityClasse c = new EntityClasse("I","A");
		c.caricaRegistroElettronico();
		assertNotNull(c.getRegistroElettronico());
	}

}
