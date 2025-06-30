package test;

import static org.junit.Assert.fail;
import entity.EntityMedia;
import static org.junit.jupiter.api.Assertions.*;
import database.DBMedia;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.EntityPagella;

class EntityMediaTest {
	@BeforeEach
	void setUp() throws Exception {
		EntityPagella p = new EntityPagella();
		int ret = p.sonoStateGenerate();
		if(ret==-1) fail("Le pagelle non sono state generate!");
	}
	@Test
	void testEntityMedia() {
		EntityMedia media = new EntityMedia();
		assertNotNull(media);
	}

	@Test
	void testEntityMediaInt() throws Exception {
		setUp();
		EntityMedia media = new EntityMedia(3);
		assertEquals(3,media.getId());
		assertNotNull(media.getAlunno());
	}

	@Test
	void testEntityMediaDBMedia() throws Exception {
		setUp();
		DBMedia m = new DBMedia(3);
		EntityMedia media = new EntityMedia(m);
		assertEquals(3,media.getId());
		assertNotNull(media.getAlunno());
	}

	@Test
	void testInserisciMedia() {
		EntityMedia media = new EntityMedia();
		media.inserisciMedia(147, 7, "Italiano", "alunno5");
		assertEquals(147,media.getId());
		assertEquals(7,media.getValore());
		assertEquals("Italiano",media.getMateria());
		assertEquals("alunno5",media.getAlunno().getUsername());
	}

	@Test
	void testAggiornaMedia() throws Exception {
		setUp();
		EntityMedia media = new EntityMedia(5);
		media.aggiornaMedia(6);
		assertEquals(6,media.getValore());
	}

}
