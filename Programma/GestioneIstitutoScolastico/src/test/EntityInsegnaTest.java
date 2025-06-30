package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import entity.EntityInsegna;
import database.DBClasse; 
import database.DBDocente;
import database.DBInsegna;

class EntityInsegnaTest {
	@Test
	void testEntityInsegna() {
		EntityInsegna in = new EntityInsegna();
		assertNotNull(in);
	}

	@Test
	void testEntityInsegnaDBClasseDBDocenteString() {
		DBClasse classe = new DBClasse("III","C");
		DBDocente docente = new DBDocente("docente1");
		EntityInsegna in = new EntityInsegna(classe,docente,"Fisica");
		assertEquals(classe.getAnno(),in.getClasse().getAnno());
		assertEquals(classe.getSezione(),in.getClasse().getSezione());
		assertEquals(docente.getUsername(),in.getDocente().getUsername());
	}

	@Test
	void testEntityInsegnaDBInsegna() {
		DBClasse classe = new DBClasse("III","C");
		DBDocente docente = new DBDocente("docente1");
		DBInsegna i = new DBInsegna(classe,docente,"Fisica");
		EntityInsegna in = new EntityInsegna(i);
		assertEquals(classe.getAnno(),in.getClasse().getAnno());
		assertEquals(classe.getSezione(),in.getClasse().getSezione());
		assertEquals(docente.getUsername(),in.getDocente().getUsername());
		assertEquals("Fisica",in.getMateria());
	}

}
