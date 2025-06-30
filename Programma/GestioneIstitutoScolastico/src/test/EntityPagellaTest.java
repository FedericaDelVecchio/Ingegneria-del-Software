package test;

import static org.junit.Assert.*;
import entity.EntityAlunno;
import entity.EntityPagella;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class EntityPagellaTest {
	@Before
	public void setUp() throws Exception {
		EntityPagella p = new EntityPagella();
		int ret = p.sonoStateGenerate();
		if(ret==-1) fail("Le pagelle non sono state generate!");
	}

	@Test
	public void testEntityPagella() {
		EntityPagella pagella = new EntityPagella();
		assertNotNull(pagella);
		assertEquals(0,pagella.isApprovata());
	}

	@Test
	public void testEntityPagellaString() throws Exception {
		setUp();
		EntityPagella pagella = new EntityPagella("alunno1");
		assertNotNull(pagella);
		assertNotNull(pagella.getAlunno());
		assertNotNull(pagella.getMedie());
	}
	
	@Test
	public void testInserisciPagella() throws Exception {
		EntityAlunno alunno = new EntityAlunno();
		alunno.registraAlunno("alunnoPROVA", null, null, null, null, null, "codiceFiscalePROVA", 0, null);
		EntityPagella p= new EntityPagella();
		int i=p.inserisciPagella("alunnoPROVA");
		assertNotEquals(-1,i);
		assertEquals(0,p.isApprovata());
		assertEquals(alunno.getUsername(),p.getAlunno().getUsername());
	}

	@Test
	public void testSonoStateGenerate() {
		EntityPagella p = new EntityPagella();
		int r = p.sonoStateGenerate();
		assertNotEquals(-1,r);
	}

	@Test
	public void testApprovaPagella() throws Exception {
		setUp();
		EntityPagella p = new EntityPagella("alunno2");
		p.approvaPagella();
		assertEquals(1,p.isApprovata());
	}
}
