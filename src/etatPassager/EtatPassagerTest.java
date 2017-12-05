package etatPassager;

import static org.junit.Assert.*;

import org.junit.Test;

import etatPassager.EtatPassager.Etat;

public class EtatPassagerTest {

	@Test
	public void testEtatPassager() 
	{
		EtatPassager etatAssis = new EtatPassager(Etat.ASSIS);
		EtatPassager etatDebout = new EtatPassager(Etat.DEBOUT);
		EtatPassager etatDehors = new EtatPassager(Etat.DEHORS);
		assertNotNull(etatAssis);
		assertNotNull(etatDebout);
		assertNotNull(etatDehors);
	}
	
		 
	@Test
	public void testAssis() {
		EtatPassager eTAssis = new EtatPassager(Etat.ASSIS);
		assertTrue(eTAssis.estAssis());
		assertFalse(eTAssis.estDebout());
		assertFalse(eTAssis.estExterieur());
	}

	@Test
	public void testDebout() {
		EtatPassager eTDebout = new EtatPassager(Etat.DEBOUT);
		assertTrue(eTDebout.estDebout());
		assertFalse(eTDebout.estAssis());
		assertFalse(eTDebout.estExterieur());
	}
	
	@Test
	public void testExterieur() {	
		EtatPassager eTDehors = new EtatPassager(Etat.DEHORS);
		assertTrue(eTDehors.estExterieur());
		assertFalse(eTDehors.estAssis());
		assertFalse(eTDehors.estDebout());
	}
	
	@Test
	public void testInterieur() {
		EtatPassager eTAssis = new EtatPassager(Etat.ASSIS);
		assertTrue(eTAssis.estInterieur());

		EtatPassager eTDebout = new EtatPassager(Etat.DEBOUT);
		assertTrue(eTDebout.estInterieur());
		
		EtatPassager eTDehors = new EtatPassager(Etat.DEHORS);
		assertFalse(eTDehors.estInterieur());
	}

}
