package tec;

import static org.junit.Assert.*;

import org.junit.Test;

import etatPassager.EtatPassager;

public abstract class PassagerStandardTest extends PassagerAbstraitTest
{
	
	PassagerAbstrait Kaylee = creerPassager("Kaylee", 5);
	PassagerAbstrait Jayne = creerPassager("Jayne", 4);
	PassagerAbstrait Inara = creerPassager("Inara", 5);
	
	protected PassagerAbstrait creerPassager(String nom, int destination)
	{
		PassagerAbstrait pS = new PassagerStandard(nom,destination); 
		return pS;
	}


	@Test
	public void choixPlaceMontee(Transport t)
	{
		Autobus weshCestLeBus = new Autobus(10,10);
		
		weshCestLeBus.demanderPlaceAssise(Kaylee);
		weshCestLeBus.demanderPlaceDebout(Inara);
		
		assertTrue(Kaylee.estAssis());
		assertFalse(Inara.estDehors());
		assertFalse(Kaylee.estDebout());
		assertTrue(Inara.estDebout());
		
		
	}
	
	@Test
	public void choixChangerPlace()
	{
		
	}

}