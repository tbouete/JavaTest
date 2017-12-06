package etatPassager;

import static org.junit.Assert.*;

import org.junit.Test;

import etatPassager.EtatPassagerChaine.Etat;

public class EtatPassagerChaineTest {

	@Test
	public void testEtatPassager() {
		EtatPassagerChaine etatAssis = new EtatPassagerChaine(Etat.ASSIS);
		EtatPassagerChaine etatDebout = new EtatPassagerChaine(Etat.DEBOUT);
		EtatPassagerChaine etatDehors = new EtatPassagerChaine(Etat.DEHORS);
		assertNotNull(etatAssis);
		assertNotNull(etatDebout);    
		assertNotNull(etatDehors);
	}

	@Test
	public void testAssis() {
		EtatPassagerChaine eTAssis = new EtatPassagerChaine(Etat.ASSIS);
		assertTrue(eTAssis.estAssis());
		assertFalse(eTAssis.estDebout());
		assertFalse(eTAssis.estExterieur());
	}

	@Test
	public void testDebout() {
		EtatPassagerChaine eTDebout = new EtatPassagerChaine(Etat.DEBOUT);
		assertTrue(eTDebout.estDebout());
		assertFalse(eTDebout.estAssis());
		assertFalse(eTDebout.estExterieur());
	}
	
	@Test
	public void testExterieur() {	
		EtatPassagerChaine eTDehors = new EtatPassagerChaine(Etat.DEHORS);
		assertTrue(eTDehors.estExterieur());
		assertFalse(eTDehors.estAssis());
		assertFalse(eTDehors.estDebout());
	}
	
	@Test
	public void testInterieur() {
		EtatPassagerChaine eTAssis = new EtatPassagerChaine(Etat.ASSIS);
		assertTrue(eTAssis.estInterieur());

		EtatPassagerChaine eTDebout = new EtatPassagerChaine(Etat.DEBOUT);
		assertTrue(eTDebout.estInterieur());
		
		EtatPassagerChaine eTDehors = new EtatPassagerChaine(Etat.DEHORS);
		assertFalse(eTDehors.estInterieur());
	}

}
