package test;

import static org.junit.jupiter.api.Assertions.*;
import entity.EntityAttivita;
import database.DBAttivita;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EntityAttivitaTest {

	@Test
	void testEntityAttivita() {
		EntityAttivita a = new EntityAttivita();
		assertNotNull(a);
	}

	@Test
	void testEntityAttivitaInt() {
		EntityAttivita a = new EntityAttivita(5);
		assertEquals(5,a.getId());
		assertNotNull(a.getClasse());
	}

	@Test
	void testEntityAttivitaDBAttivita() {
		DBAttivita attivita = new DBAttivita(5);
		EntityAttivita a = new EntityAttivita(attivita);
		assertEquals(5,a.getId());
		assertNotNull(a.getClasse());
	}

	@Test
	void testInserisciAttivita() {
		EntityAttivita a = new EntityAttivita();
		a.inserisciAttivita("Arte", "Ripetizione", "13/04/2022", "I", "A");
		assertEquals("Arte",a.getMateria());
		assertEquals("Ripetizione",a.getDescrizione());
		assertEquals("13/04/2022",a.getData());
		assertEquals("I",a.getClasse().getAnno());
		assertEquals("A",a.getClasse().getSezione());
	}

}
