package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.EntityPreside;

public class EntityPresideTest {
	@Test
	void testEntityPresideString() {
		EntityPreside preside = new EntityPreside("preside1");
		assertEquals("preside1",preside.getUsername());
	}

	@Test
	void testCaricaClassi() {
		EntityPreside preside = new EntityPreside("preside1");
		preside.caricaClassi();
		assertNotNull(preside.getClassi());
	}
}
