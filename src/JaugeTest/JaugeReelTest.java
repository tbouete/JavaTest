package JaugeTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class JaugeReelTest {
	
	JaugeReel jaugeVerte = new JaugeReel(0, 5, 2);
	JaugeReel jaugeRouge = new JaugeReel(0, 5, 6);
	JaugeReel jaugeRougeBis = new JaugeReel(0, 5, 5);
	JaugeReel jaugeBleue = new JaugeReel(0, 5, -2);
	JaugeReel jaugeBleueBis = new JaugeReel(0, 5, 0);
	JaugeReel jaugeLimite1 = new JaugeReel(5, 0, 2); //vigieMax < depart < vigieMin
	JaugeReel jaugeLimite2 = new JaugeReel(5, 5, 2); //vigieMin = VigieMax < depart 
	JaugeReel jaugeLimite3 = new JaugeReel(5, 5, 5);
	
	@Test
	public void testEstVert()
	{
		String messErreur1 = "une jauge à la limite inférieure ne doit pas être verte";
		String messErreur2 = "une jauge à la limite supérieure ne doit pas être verte";
		
		assertTrue(jaugeVerte.estVert());
		assertFalse(jaugeRouge.estVert());
		assertFalse(jaugeBleue.estVert());
		
		assertFalse(messErreur1, jaugeBleueBis.estVert()); 
		assertFalse(messErreur2, jaugeRougeBis.estVert());
	}
	
	@Test
	public void testEstBleu()
	{
		assertFalse(jaugeVerte.estBleu());
		assertFalse(jaugeRouge.estBleu());
		assertTrue(jaugeBleue.estBleu());
		
		assertTrue("valeur égale à la limite inférieur", jaugeBleueBis.estBleu());
	}
	
	@Test
	public void testEstRouge()
	{
		assertFalse(jaugeVerte.estRouge());
		assertTrue(jaugeRouge.estRouge());
		assertFalse(jaugeBleue.estRouge());
		assertTrue("valeur égale a la limite supérieur", jaugeRougeBis.estRouge());
	}
	
	
	@Test
	public void testIncrementer()
	{
		jaugeBleueBis.incrementer();
		assertTrue(jaugeBleueBis.estVert());
	}
	
	@Test
	public void testDecrementer()
	{		
		jaugeRougeBis.decrementer();
		assertTrue(jaugeRougeBis.estVert());
	}
	

	
	@Test
	public void testDansIntervalle() 
	{
		assertFalse(jaugeVerte.estBleu());
		assertTrue(jaugeVerte.estVert());
		assertFalse(jaugeVerte.estRouge());
	}
	
	
	
	@Test
	public void testDeplacement()
	{
		for (int i = 0; i < 3 ; i++)
		{
			jaugeVerte.decrementer();
		}
		assertTrue(jaugeVerte.estBleu());
		assertFalse(jaugeVerte.estVert());
		assertFalse(jaugeVerte.estRouge());
		
		for (int j = 0; j < 3 ; j++)
		{
			jaugeVerte.incrementer();
		}
		assertFalse(jaugeVerte.estBleu());
		assertTrue(jaugeVerte.estVert());
		assertFalse(jaugeVerte.estRouge());
	}
	
	@Test
	public void testInferieurIntervalle()
	{
		//1) depart < vigieMin < vigieMax, 
			//utilisation de jaugeBleue avec depart = -2, vigieMin = 0 , vigieMax = 5
		
		assertTrue(jaugeBleue.estBleu());
		assertFalse(jaugeBleue.estRouge());
		assertFalse(jaugeBleue.estVert());
		
		
		//2) depart = vigieMin < vigieMax.
			//utilisation de jaugeBleueBis avec depart = 0, vigieMin = 0 , vigieMax = 5
		
		assertTrue(jaugeBleueBis.estBleu());
		assertFalse(jaugeBleueBis.estRouge());
		assertFalse(jaugeBleueBis.estVert());
		
	}
	
	@Test
	public void testLimiteVigieMaxInferieurVigieMin()
	{
		//nope nope nope
	}
	
	@Test
	public void testMaxEgaleMin()
	{
		
		//1) vigieMin = VigieMax < depart
			//utilisation de jaugeLimite2 avec depart = 2, vigieMin = 5 , vigieMax = 5
		
		assertTrue(jaugeLimite2.estBleu());
		assertFalse(jaugeLimite2.estVert());
		assertFalse(jaugeLimite2.estRouge());
		
		//2) vigieMin = VigieMax = depart
			// utilisation de jaugeLimite3 depart = 5, vigieMin = 5 , vigieMax = 5
		assertTrue(jaugeLimite3.estBleu());
		assertFalse(jaugeLimite3.estVert());
		assertTrue(jaugeLimite3.estRouge());
	}
	
	
	@Test
	public void testSuperieurIntervalle()
	{
		//1) vigieMin < vigieMax < depart 
		//utilisation de jaugeRouge avec depart = 6, vigieMin = 0 , vigieMax = 5
	
	assertFalse(jaugeRouge.estBleu());
	assertTrue(jaugeRouge.estRouge());
	assertFalse(jaugeRouge.estVert());
	
	
	//2) vigieMin < vigieMax = depart
		//utilisation de jaugeRougeBis avec depart = 5, vigieMin = 0 , vigieMax = 5
	
	assertFalse(jaugeRougeBis.estBleu());
	assertTrue(jaugeRougeBis.estRouge());
	assertFalse(jaugeRougeBis.estVert());
	
	}
	
	
}
