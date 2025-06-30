package test;

import static org.junit.jupiter.api.Assertions.*;

import entity.EntityClasse;
import database.DBRegistroElettronico;
import entity.EntityRegistroElettronico;
import database.DBClasse;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EntityRegistroElettronicoTest {
	@Test
	void testEntityRegistroElettronico() {
		EntityRegistroElettronico re = new EntityRegistroElettronico();
		assertNotNull(re);
	}

	@Test
	void testEntityRegistroElettronicoStringString() {
		EntityRegistroElettronico re = new EntityRegistroElettronico("III","C");
		assertNotNull(re.getClasse());
		assertEquals("III",re.getClasse().getAnno());
		assertEquals("C",re.getClasse().getSezione());
	}

	@Test
	void testEntityRegistroElettronicoDBClasse() {
		DBClasse classe = new DBClasse("III","C");
		EntityRegistroElettronico re = new EntityRegistroElettronico(classe);
		assertNotNull(re.getClasse());
		assertEquals("III",re.getClasse().getAnno());
		assertEquals("C",re.getClasse().getSezione());
	}

	@Test
	void testCaricaVoti() {
		EntityRegistroElettronico re = new EntityRegistroElettronico("III","C");
		re.caricaVoti();
		assertNotNull(re.getVoti());
	}

	@Test
	void testCaricaVotiDBRegistroElettronico() {
		EntityRegistroElettronico re = new EntityRegistroElettronico("III","C");
		DBRegistroElettronico regele = new DBRegistroElettronico("III","C");
		re.caricaVoti(regele);
		assertNotNull(re.getVoti());
	}

	@Test
	void testCaricaAttivita() {
		EntityRegistroElettronico re = new EntityRegistroElettronico("III","C");
		re.caricaAttivita();
		assertNotNull(re.getAttivita());
	}

	@Test
	void testCaricaAttivitaDBRegistroElettronico() {
		EntityRegistroElettronico re = new EntityRegistroElettronico("III","C");
		DBRegistroElettronico regele = new DBRegistroElettronico("III","C");
		re.caricaAttivita(regele);
		assertNotNull(re.getAttivita());
	}

}
