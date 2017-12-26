package tec;

import static org.junit.Assert.*;

import org.junit.Test;

public abstract class PassagerAbstraitTest
{
	
	PassagerAbstrait Kaylee = creerPassager("Kaylee", 5);
	PassagerAbstrait Jayne = creerPassager("Jayne", 4);
	PassagerAbstrait Inara = creerPassager("Inara", 3);
	
	
	abstract protected PassagerAbstrait creerPassager(String nom, int destination);

	@Test
	public void testNom()
	{
		assertEquals("Kaylee",Kaylee.nom());
		assertFalse("Jayne".equals(Kaylee.nom()));
	}



	@Test
	public void testEstDehors()
	{
		Jayne.accepterPlaceAssise();
		Inara.accepterPlaceDebout();

		assertTrue(Kaylee.estDehors());
		assertFalse(Jayne.estDehors());
		assertFalse(Inara.estDehors());
	}	  



	@Test
	public void testEstAssis()
	{
		Jayne.accepterPlaceAssise();
		Inara.accepterPlaceDebout();

		assertFalse(Kaylee.estAssis());
		assertTrue(Jayne.estAssis());
		assertFalse(Inara.estAssis());

	}



	@Test
	public void testEstDebout()
	{
		Jayne.accepterPlaceAssise();
		Inara.accepterPlaceDebout();

		assertFalse(Kaylee.estDebout());
		assertFalse(Jayne.estDebout());
		assertTrue(Inara.estDebout());
	}
	
	public void testEstInterieur()
	{
		Kaylee.accepterSortie();
		Jayne.accepterPlaceAssise();
		Inara.accepterPlaceDebout();
		

		assertFalse(Kaylee.estInterieur());
		assertTrue(Jayne.estInterieur());
		assertTrue(Inara.estInterieur());
	}



	@Test
	public void testAccepterSortie()
	{
		Kaylee.accepterPlaceAssise();
		Jayne.accepterSortie();
		Inara.accepterPlaceDebout();

		assertFalse(Kaylee.estDehors());
		assertTrue(Jayne.estDehors());
		assertFalse(Inara.estDehors());

	}




	@Test
	public void testAccepterPlaceAssise()
	{
		Kaylee.accepterSortie();
		Jayne.accepterPlaceAssise();
		Inara.accepterPlaceDebout();

		assertFalse(Kaylee.estAssis());
		assertTrue(Jayne.estAssis());
		assertFalse(Inara.estAssis());
	}




	@Test
	public void testAccepterPlaceDebout()
	{
		Kaylee.accepterSortie();
		Jayne.accepterPlaceAssise();
		Inara.accepterPlaceDebout();

		assertFalse(Kaylee.estDebout());
		assertFalse(Jayne.estDebout());
		assertTrue(Inara.estDebout());	  

	}




	@Test
	public void testNouvelArret()
	{
		Kaylee.accepterPlaceAssise();
		Jayne.accepterPlaceAssise();
		Inara.accepterPlaceDebout();

		Autobus bubus1 = new Autobus(10,10);
		
		for(int i=0 ; i<4 ; i++)
		{
			try
			{
				bubus1.allerArretSuivant();
			}
			catch (UsagerInvalideException e)
			{
				e.printStackTrace();
				fail();
			}
		}
		
		assertFalse(Kaylee.estDehors());
		assertTrue(Jayne.estDehors());
		assertTrue(Inara.estInterieur());	
	}
	
	
	
	@Test
	public void testMonterDans() throws UsagerInvalideException
	{
		Autobus chatBus = new Autobus(10,10);
		Kaylee.monterDans(chatBus);

		chatBus.demanderPlaceAssise(Kaylee);
		chatBus.demanderPlaceAssise(Jayne);
		
		assertTrue(Kaylee.estInterieur());
		assertTrue( ! (Jayne.estDehors()) );
		
	}

	public abstract void testChoixPlaceMontee();

	public abstract void testChoixChangerPlace();
}
