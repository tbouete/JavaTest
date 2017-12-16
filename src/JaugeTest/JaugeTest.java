package JaugeTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class JaugeTest 
{	
	public JaugeTest()
	{
		
	}
	
	private Jauge creerJauge(JaugeType type, long min, long max,long depart) throws IllegalArgumentException
	{
		Jauge ret;
//		Jauge ret = null;
//		try
//		{
			switch(type)
			{
			case JaugeDistance : ret = new JaugeDistance(min, max, depart); break;
			case JaugeNaturel : ret = new JaugeNaturel(min, max, depart); break;
			case JaugeNegatif : ret = new JaugeNegatif(min, max, depart); break;
			case JaugeReel : ret = new JaugeReel(min, max, depart); break;
			default : throw new IllegalArgumentException();
			}
			
			return ret;
//		}		
//		catch(IllegalArgumentException e)
//		{	
//			assertFalse("L'instanciation n'a pas fonctionnée car il n'y a pas correspondance de type", false);
//			return ret;
//		}
	}
	
	long[] jaugeVerteValues = {0, 5, 2}; 
	long[] jaugeRougeValues = {0, 5, 6}; 
	long[] jaugeRougeBisValues = {0, 5, 5};
	long[] jaugeBleueValues = {0, 5, -2};
	long[] jaugeBleueBisValues = {0, 5, 0}; 
	long[] jaugeLimite1Values = {5, 0, 2}; 
	long[] jaugeLimite2Values = {5, 5, 2}; 
	long[] jaugeLimite3Values = {5, 5, 5}; 
	
	
	@Test
	public void testCreationNonValide()
	{
		try
		{
			try
			{
				for(JaugeType type : JaugeType.values())
				{
					Jauge inverse = creerJauge(type,78,13,0);
					Jauge egale = creerJauge(type,-45,-45,-45);
				}	
			}
			catch(IllegalArgumentException e)
			{
				
			}
		}
		catch(IllegalArgumentException fe)
		{
			fail("La création a échoué mais n'a pas été relevé");			
		}
	}
	
	@Test
	public void testEstVert()
	{
		String messErreur1 = "une jauge à la limite inférieure ne doit pas être verte";
		String messErreur2 = "une jauge à la limite supérieure ne doit pas être verte";
		
		for(JaugeType type : JaugeType.values())
		{
			Jauge jaugeVerte = this.creerJauge(type, jaugeVerteValues[0], jaugeVerteValues[1], jaugeVerteValues[2]);
			assertTrue(jaugeVerte.estVert());
		}
			
		for(JaugeType type : JaugeType.values())
		{			
			Jauge jaugeRouge = this.creerJauge(type, jaugeRougeValues[0], jaugeRougeValues[1], jaugeRougeValues[2]);
			assertFalse(jaugeRouge.estVert());
		}
		
		for(JaugeType type : JaugeType.values())
		{
			Jauge jaugeBleue = this.creerJauge(type, jaugeBleueValues[0], jaugeBleueValues[1], jaugeBleueValues[2]);
			assertFalse(jaugeBleue.estVert());
		}
			
		for(JaugeType type : JaugeType.values())
		{
			Jauge jaugeBleueBis = this.creerJauge(type, jaugeBleueBisValues[0], jaugeBleueBisValues[1], jaugeBleueBisValues[2]);
			assertFalse(jaugeBleueBis.estVert());
		}
			
		for(JaugeType type : JaugeType.values())
		{
			Jauge jaugeRougeBis = this.creerJauge(type, jaugeRougeBisValues[0], jaugeRougeBisValues[1], jaugeRougeBisValues[2]);
			assertFalse(jaugeRougeBis.estVert());
		}
					
		
	}
	
	@Test
	public void testEstBleu()
	{	
		String messErreur1 = "valeur égale à la limite inférieur";
		
		for(JaugeType type : JaugeType.values())
		{
			Jauge jaugeVerte = this.creerJauge(type, jaugeVerteValues[0], jaugeVerteValues[1], jaugeVerteValues[2]);
			assertFalse(jaugeVerte.estBleu());
		}
		
			
		for(JaugeType type : JaugeType.values())
		{
			Jauge jaugeRouge = this.creerJauge(type, jaugeRougeValues[0], jaugeRougeValues[1], jaugeRougeValues[2]);
			assertFalse(jaugeRouge.estBleu());
		}
				
		
		for(JaugeType type : JaugeType.values())
		{
			Jauge jaugeBleue = this.creerJauge(type, jaugeBleueValues[0], jaugeBleueValues[1], jaugeBleueValues[2]);
			assertTrue(jaugeBleue.estBleu());
		}
			
		for(JaugeType type : JaugeType.values())
		{
			Jauge jaugeBleueBis = this.creerJauge(type, jaugeBleueBisValues[0], jaugeBleueBisValues[1], jaugeBleueBisValues[2]);
			assertTrue(messErreur1, jaugeBleueBis.estBleu());
		}
			
	}
		
	
	@Test
	public void testEstRouge()
	{
		
		String messErreur1 = "valeur égale a la limite supérieur";
		
		for(JaugeType type : JaugeType.values())
		{
			Jauge jaugeVerte = this.creerJauge(type, jaugeVerteValues[0], jaugeVerteValues[1], jaugeVerteValues[2]);
			assertFalse(jaugeVerte.estRouge());
		}
		
		for(JaugeType type : JaugeType.values())
		{
			Jauge jaugeRouge = this.creerJauge(type, jaugeRougeValues[0], jaugeRougeValues[1], jaugeRougeValues[2]);
			assertTrue(jaugeRouge.estRouge());
		}
			
		
		for(JaugeType type : JaugeType.values())
		{
			Jauge jaugeBleue = this.creerJauge(type, jaugeBleueValues[0], jaugeBleueValues[1], jaugeBleueValues[2]);
			assertFalse(jaugeBleue.estRouge());
		}
			
		
		for(JaugeType type : JaugeType.values())
		{
			Jauge jaugeRougeBis = this.creerJauge(type, jaugeRougeBisValues[0], jaugeRougeBisValues[1], jaugeRougeBisValues[2]);
			assertTrue(messErreur1, jaugeRougeBis.estRouge());
		}
	}
	
	
	@Test
	public void testIncrementer()
	{
		for(JaugeType type : JaugeType.values())
		{
			Jauge jaugeBleueBis = this.creerJauge(type, jaugeBleueBisValues[0], jaugeBleueBisValues[1], jaugeBleueBisValues[2]);
			jaugeBleueBis.incrementer();
			assertTrue(jaugeBleueBis.estVert());
		}		
	}
	
	@Test
	public void testDecrementer()
	{				
		for(JaugeType type : JaugeType.values())
		{
			Jauge jaugeRougeBis = this.creerJauge(type, jaugeRougeBisValues[0], jaugeRougeBisValues[1], jaugeRougeBisValues[2]);
			jaugeRougeBis.decrementer();
			assertTrue(jaugeRougeBis.estVert());
		}
	}
	
	
	@Test
	public void testDansIntervalle() 
	{
		for(JaugeType type : JaugeType.values())
		{
			Jauge jaugeVerte = this.creerJauge(type, jaugeVerteValues[0], jaugeVerteValues[1], jaugeVerteValues[2]);
			assertFalse(jaugeVerte.estBleu());
			assertTrue(jaugeVerte.estVert());
			assertFalse(jaugeVerte.estRouge());
		}
	}
	
	
	
	@Test
	public void testDeplacement()
	{
		for(JaugeType type : JaugeType.values())
		{
			Jauge jaugeVerte = this.creerJauge(type, jaugeVerteValues[0], jaugeVerteValues[1], jaugeVerteValues[2]);
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
	}
	
	@Test
	public void testInferieurIntervalle()
	{
		//1) depart < vigieMin < vigieMax, 
			//utilisation de jaugeBleue avec depart = -2, vigieMin = 0 , vigieMax = 5
		
		for(JaugeType type : JaugeType.values())
		{
			Jauge jaugeBleue = this.creerJauge(type, jaugeBleueValues[0], jaugeBleueValues[1], jaugeBleueValues[2]);
			assertTrue(jaugeBleue.estBleu());
			assertFalse(jaugeBleue.estRouge());
			assertFalse(jaugeBleue.estVert());
		}

		
		//2) depart = vigieMin < vigieMax.
			//utilisation de jaugeBleueBis avec depart = 0, vigieMin = 0 , vigieMax = 5
		
		for(JaugeType type : JaugeType.values())
		{
			Jauge jaugeBleueBis = this.creerJauge(type, jaugeBleueBisValues[0], jaugeBleueBisValues[1], jaugeBleueBisValues[2]);
			assertTrue(jaugeBleueBis.estBleu());
			assertFalse(jaugeBleueBis.estRouge());
			assertFalse(jaugeBleueBis.estVert());
		}
	
	}

//	
	
	
	@Test
	public void testSuperieurIntervalle()
	{
		//1) vigieMin < vigieMax < depart 
		//utilisation de jaugeRouge avec depart = 6, vigieMin = 0 , vigieMax = 5
	
		for(JaugeType type : JaugeType.values())
		{
			Jauge jaugeRouge = this.creerJauge(type, jaugeRougeValues[0], jaugeRougeValues[1], jaugeRougeValues[2]);
			assertFalse(jaugeRouge.estBleu());
			assertTrue(jaugeRouge.estRouge());
			assertFalse(jaugeRouge.estVert());
		}
		
	
	
	//2) vigieMin < vigieMax = depart
		//utilisation de jaugeRougeBis avec depart = 5, vigieMin = 0 , vigieMax = 5
	
		for(JaugeType type : JaugeType.values())
		{
			Jauge jaugeRougeBis = this.creerJauge(type, jaugeRougeBisValues[0], jaugeRougeBisValues[1], jaugeRougeBisValues[2]);
			assertFalse(jaugeRougeBis.estBleu());
			assertTrue(jaugeRougeBis.estRouge());
			assertFalse(jaugeRougeBis.estVert());
		}
	}
}
