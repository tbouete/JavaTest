package JaugeTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class JaugeTest 
{
	
	private Jauge creerJauge(JaugeType type, long min, long max,long depart) throws IllegalArgumentException{
		Jauge ret;
		
		switch(type){
		case JaugeDistance : ret = new JaugeDistance(min, max, depart); break;
		case JaugeNaturel : ret = new JaugeNaturel(min, max, depart); break;
		case JaugeNegatif : ret = new JaugeNegatif(min, max, depart); break;
		case JaugeReel : ret = new JaugeReel(min, max, depart); break;
		default : throw new IllegalArgumentException();
		}
		
		return ret;
	}
	
	long[] jaugeVerteValues = {0, 5, 2}; 
	long[] jaugeRougeValues = {0, 5, 6}; 
	long[] jaugeRougeBisValues = {0, 5, 5};
	long[] jaugeBleueValues = {0, 5, -2};
	long[] jaugeBleueBisValues = {0, 5, 0}; 
	long[] jaugeLimite1Values = {5, 0, 2}; 
	long[] jaugeLimite2Values = {5, 5, 2}; 
	long[] jaugeLimite3Values = {5, 5, 5}; 
	
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
		
		for(JaugeType type : JaugeType.values()){
			Jauge jaugeVerte = this.creerJauge(type, jaugeVerteValues[0], jaugeVerteValues[1], jaugeVerteValues[2]);
			assertTrue(jaugeVerte.estVert());
		}
		
		for(JaugeType type : JaugeType.values()){
			Jauge jaugeRouge = this.creerJauge(type, jaugeRougeValues[0], jaugeRougeValues[1], jaugeRougeValues[2]);
			assertFalse(jaugeRouge.estVert());
		}
		
		for(JaugeType type : JaugeType.values()){
			Jauge jaugeBleue = this.creerJauge(type, jaugeBleueValues[0], jaugeBleueValues[1], jaugeBleueValues[2]);
			assertFalse(jaugeBleue.estVert());
		}
		
		for(JaugeType type : JaugeType.values()){
			Jauge jaugeBleueBis = this.creerJauge(type, jaugeBleueBisValues[0], jaugeBleueBisValues[1], jaugeBleueBisValues[2]);
			assertFalse(messErreur1, jaugeBleueBis.estVert());
		}
		
		for(JaugeType type : JaugeType.values()){
			Jauge jaugeRougeBis = this.creerJauge(type, jaugeRougeBisValues[0], jaugeRougeBisValues[1], jaugeRougeBisValues[2]);
			assertFalse(messErreur2, jaugeRougeBis.estVert());
		}
	}
	
	@Test
	public void testEstBleu()
	{
		
		String messErreur1 = "valeur égale à la limite inférieur";
		
		for(JaugeType type : JaugeType.values()){
			Jauge jaugeVerte = this.creerJauge(type, jaugeVerteValues[0], jaugeVerteValues[1], jaugeVerteValues[2]);
			assertFalse(jaugeVerte.estBleu());
		}
		
		for(JaugeType type : JaugeType.values()){
			Jauge jaugeRouge = this.creerJauge(type, jaugeRougeValues[0], jaugeRougeValues[1], jaugeRougeValues[2]);
			assertFalse(jaugeRouge.estBleu());
		}
		
		for(JaugeType type : JaugeType.values()){
			Jauge jaugeBleue = this.creerJauge(type, jaugeBleueValues[0], jaugeBleueValues[1], jaugeBleueValues[2]);
			assertTrue(jaugeBleue.estBleu());
		}
		
		for(JaugeType type : JaugeType.values()){
			Jauge jaugeBleueBis = this.creerJauge(type, jaugeBleueBisValues[0], jaugeBleueBisValues[1], jaugeBleueBisValues[2]);
			assertTrue(messErreur1, jaugeBleueBis.estBleu());
		}
	}
	
	@Test
	public void testEstRouge()
	{
		
		String messErreur1 = "valeur égale a la limite supérieur";
		
		for(JaugeType type : JaugeType.values()){
			Jauge jaugeVerte = this.creerJauge(type, jaugeVerteValues[0], jaugeVerteValues[1], jaugeVerteValues[2]);
			assertFalse(jaugeVerte.estRouge());
		}
		
		for(JaugeType type : JaugeType.values()){
			Jauge jaugeRouge = this.creerJauge(type, jaugeRougeValues[0], jaugeRougeValues[1], jaugeRougeValues[2]);
			assertTrue(jaugeRouge.estRouge());
		}
		
		for(JaugeType type : JaugeType.values()){
			Jauge jaugeBleue = this.creerJauge(type, jaugeBleueValues[0], jaugeBleueValues[1], jaugeBleueValues[2]);
			assertFalse(jaugeBleue.estRouge());
		}
		
		for(JaugeType type : JaugeType.values()){
			Jauge jaugeRougeBis = this.creerJauge(type, jaugeRougeBisValues[0], jaugeRougeBisValues[1], jaugeRougeBisValues[2]);
			assertTrue(messErreur1, jaugeRougeBis.estRouge());
		}
	}
	
	
	@Test
	public void testIncrementer()
	{
		for(JaugeType type : JaugeType.values()){
			Jauge jaugeBleueBis = this.creerJauge(type, jaugeBleueBisValues[0], jaugeBleueBisValues[1], jaugeBleueBisValues[2]);
			jaugeBleueBis.incrementer();
			assertTrue(jaugeBleueBis.estVert());
		}		
	}
	
	@Test
	public void testDecrementer()
	{				
		for(JaugeType type : JaugeType.values()){
			Jauge jaugeRougeBis = this.creerJauge(type, jaugeRougeBisValues[0], jaugeRougeBisValues[1], jaugeRougeBisValues[2]);
			jaugeRougeBis.decrementer();
			assertTrue(jaugeRougeBis.estVert());
		}
		
	}
	

	
	@Test
	public void testDansIntervalle() 
	{
		for(JaugeType type : JaugeType.values()){
			Jauge jaugeVerte = this.creerJauge(type, jaugeVerteValues[0], jaugeVerteValues[1], jaugeVerteValues[2]);
			assertFalse(jaugeVerte.estBleu());
			assertTrue(jaugeVerte.estVert());
			assertFalse(jaugeVerte.estRouge());
		}
	}
	
	
	
	@Test
	public void testDeplacement()
	{
		for(JaugeType type : JaugeType.values()){
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
		
		for(JaugeType type : JaugeType.values()){
			Jauge jaugeBleue = this.creerJauge(type, jaugeBleueValues[0], jaugeBleueValues[1], jaugeBleueValues[2]);
			assertTrue(jaugeBleue.estBleu());
			assertFalse(jaugeBleue.estRouge());
			assertFalse(jaugeBleue.estVert());
		}

		
		//2) depart = vigieMin < vigieMax.
			//utilisation de jaugeBleueBis avec depart = 0, vigieMin = 0 , vigieMax = 5
		
		for(JaugeType type : JaugeType.values()){
			Jauge jaugeBleueBis = this.creerJauge(type, jaugeBleueBisValues[0], jaugeBleueBisValues[1], jaugeBleueBisValues[2]);
			assertTrue(jaugeBleueBis.estBleu());
			assertFalse(jaugeBleueBis.estRouge());
			assertFalse(jaugeBleueBis.estVert());
		}	
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
		
		for(JaugeType type : JaugeType.values()){
			Jauge jaugeLimite2 = this.creerJauge(type, jaugeLimite2Values[0], jaugeLimite2Values[1], jaugeLimite2Values[2]);
			assertTrue(jaugeLimite2.estBleu());
			assertFalse(jaugeLimite2.estVert());
			assertFalse(jaugeLimite2.estRouge());
		}
		
		//2) vigieMin = VigieMax = depart
			// utilisation de jaugeLimite3 depart = 5, vigieMin = 5 , vigieMax = 5
		
		for(JaugeType type : JaugeType.values()){
			Jauge jaugeLimite3 = this.creerJauge(type, jaugeLimite3Values[0], jaugeLimite3Values[1], jaugeLimite3Values[2]);
			assertTrue(jaugeLimite3.estBleu());
			assertFalse(jaugeLimite3.estVert());
			assertTrue(jaugeLimite3.estRouge());
		}
	}
	
	
	@Test
	public void testSuperieurIntervalle()
	{
		//1) vigieMin < vigieMax < depart 
		//utilisation de jaugeRouge avec depart = 6, vigieMin = 0 , vigieMax = 5
	
		for(JaugeType type : JaugeType.values()){
			Jauge jaugeRouge = this.creerJauge(type, jaugeRougeValues[0], jaugeRougeValues[1], jaugeRougeValues[2]);
			assertFalse(jaugeRouge.estBleu());
			assertTrue(jaugeRouge.estRouge());
			assertFalse(jaugeRouge.estVert());
		}
		
	
	
	
	//2) vigieMin < vigieMax = depart
		//utilisation de jaugeRougeBis avec depart = 5, vigieMin = 0 , vigieMax = 5
	
		for(JaugeType type : JaugeType.values()){
			Jauge jaugeRougeBis = this.creerJauge(type, jaugeRougeBisValues[0], jaugeRougeBisValues[1], jaugeRougeBisValues[2]);
			assertFalse(jaugeRougeBis.estBleu());
			assertTrue(jaugeRougeBis.estRouge());
			assertFalse(jaugeRougeBis.estVert());
		}
	}
}
