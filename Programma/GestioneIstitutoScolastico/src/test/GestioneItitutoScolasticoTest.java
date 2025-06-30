package test;

import static org.junit.jupiter.api.Assertions.*;
import control.GestioneIstitutoScolastico;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GestioneItitutoScolasticoTest {
	@Test
	void testStampaClassiEAlunni() {
		GestioneIstitutoScolastico gis = new GestioneIstitutoScolastico();
		String str=gis.stampaClassiEAlunni(null);
		System.out.println(str);
		str=gis.stampaClassiEAlunni("nonEsite");
		System.out.println(str);
		str=gis.stampaClassiEAlunni("alunno4");
		System.out.println(str);
	}
	
	@Test
	void testStampaClassiEMaterie() {
		GestioneIstitutoScolastico gis = new GestioneIstitutoScolastico();
		String str=gis.stampaClassiEMaterie(null);
		System.out.println(str);
		str=gis.stampaClassiEMaterie("nonEsite");
		System.out.println(str);
		str=gis.stampaClassiEMaterie("alunno4");
		System.out.println(str);
	}

	@Test
	void testStampaAlunni() {
		GestioneIstitutoScolastico gis = new GestioneIstitutoScolastico();
		String str=gis.stampaAlunni(null,null);
		System.out.println(str);
		str=gis.stampaAlunni("I",null);
		System.out.println(str);
		str=gis.stampaAlunni(null,"A");
		System.out.println(str);
		str=gis.stampaAlunni("I","F"); // non esiste
		System.out.println(str);
		str=gis.stampaAlunni("III","C");
		System.out.println(str);
	}
	
	@Test
	void testStampaFigli() {
		GestioneIstitutoScolastico gis = new GestioneIstitutoScolastico();
		String str=gis.stampaFigli(null);
		System.out.println(str);
		str=gis.stampaFigli("nonEsite");
		System.out.println(str);
		str=gis.stampaFigli("genitore6");
		System.out.println(str);
	}

	@Test
	void testLetturaAttivita() {
		GestioneIstitutoScolastico gis = new GestioneIstitutoScolastico();
		String str=gis.letturaAttivita("alunno14","10/09/2022");
		System.out.println(str);
	}

	@Test
	void testLetturaCarriera() {
		GestioneIstitutoScolastico gis = new GestioneIstitutoScolastico();
		String str=gis.letturaCarriera("alunno16");
		System.out.println(str);
	}
	@Test
	void testGenerazionePagelle() {
		GestioneIstitutoScolastico gis = new GestioneIstitutoScolastico();
		// gis.generazionePagelle();
	}

	@Test
	void testModificaPagella() {
		GestioneIstitutoScolastico gis = new GestioneIstitutoScolastico();
		String r=gis.modificaPagella("alunno5", "Arte", 0);
		System.out.println(r);
	}
	
	@Test
	void testApprovazionePagella() {
		GestioneIstitutoScolastico gis = new GestioneIstitutoScolastico();
		String r=gis.approvazionePagella("alunno8");
		System.out.println(r);
	}
	
	@Test
	void testInserimentoUtente () {
		GestioneIstitutoScolastico g = new GestioneIstitutoScolastico ();
		String ris=g.inserimentoUtente("alunno39","passw","Mario@39","Rossi","Napoli","12/02/2002","ASDQWE123456GFDE",1234567890,"marioross@gmail.com","alunno");
		assertNotEquals("L'utente e' stato inserito correttamente\n",ris);
	}

}
