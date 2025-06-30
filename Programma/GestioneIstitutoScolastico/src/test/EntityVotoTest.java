package test;

import static org.junit.jupiter.api.Assertions.*;
import entity.EntityVoto;
import entity.EntityAlunno;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EntityVotoTest {
	@Test
	void testEntityVoto() {
		EntityVoto voto = new EntityVoto();
		assertNotNull(voto);
	}

	@Test
	void testEntityVotoInt() {
		EntityVoto voto = new EntityVoto(1);
		assertNotNull(voto.getAlunno());
		assertEquals(1,voto.getId());
	}

	@Test
	void testInserisciVoto() {
		EntityVoto voto = new EntityVoto();
		voto.inserisciVoto(7, "Arte", "12/03/2023", "III", "C", "alunno4");
		assertNotNull(voto.getAlunno());
		assertEquals(7,voto.getValore());
		assertEquals("Arte",voto.getMateria());
		assertEquals("alunno4",voto.getAlunno().getUsername());
	}

	@Test
	void testSetAlunno() {
		EntityAlunno alunno = new EntityAlunno("alunno3");
		EntityVoto voto = new EntityVoto();
		voto.setAlunno(alunno);
		assertEquals(alunno,voto.getAlunno());
	}

}
