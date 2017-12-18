package tec;

import static org.junit.Assert.*;

import org.junit.Test;

import etatPassager.EtatPassager;

public class PassagerStandardTest 
{

	PassagerStandard Kaylee = new PassagerStandard("Kaylee", 5);
	PassagerStandard Jayne = new PassagerStandard("Jayne", 4);
	PassagerStandard Inara = new PassagerStandard("Inara", 5);




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
		PassagerStandard harry = new PassagerStandard("Harry",1);
		PassagerStandard hermione = new PassagerStandard("Hermione",3);
		PassagerStandard ron = new PassagerStandard("Ron",6);
		PassagerStandard neuville = new PassagerStandard("Neuville",10);

		FauxBusDebout edwige = new FauxBusDebout();
		FauxBusAssis pattenrond = new FauxBusAssis();
		FauxBusVide coquecigrue = new FauxBusVide();
		FauxBusPlein trevor = new FauxBusPlein();

		try
		{
			harry.monterDans(edwige);
			edwige.allerArretSuivant();
			assertTrue(harry.estDehors());	
		}
		catch(UsagerInvalideException e)
		{
			e.printStackTrace();				
		}

		
		
		try
		{
			hermione.monterDans(edwige);
			pattenrond.allerArretSuivant();
			assertTrue(hermione.estDehors());
		}
		catch(UsagerInvalideException e)
		{
			e.printStackTrace();				
		}




		try
		{
			ron.monterDans(coquecigrue);
			for(int i = 0; i < 6 ; i++)
			{
				coquecigrue.allerArretSuivant();
			}
			assertTrue(ron.estDehors());
		}
		catch(UsagerInvalideException e)
		{
			e.printStackTrace();				
		}



		try
		{
			neuville.monterDans(trevor);
			trevor.allerArretSuivant();
			assertTrue(neuville.estDehors());
		}
		catch(UsagerInvalideException e)
		{
			e.printStackTrace();				
		}


	}		  




	@Test
	public void testMonterDans()
	{
		PassagerStandard harry = new PassagerStandard("Harry",10);
		FauxBusDebout edwige = new FauxBusDebout();
		try
		{	
			harry.monterDans(edwige);
			System.out.println(harry.monEtat);
			assertFalse(harry.estDehors());
		}

		catch(UsagerInvalideException e)
		{
			e.printStackTrace();				
		}



		PassagerStandard hermione = new PassagerStandard("Hermione",10);
		FauxBusPlein pattenrond = new FauxBusPlein();
		try
		{	
			hermione.monterDans(pattenrond);
			assertTrue(hermione.estDehors());
		}

		catch(UsagerInvalideException e)
		{
			e.printStackTrace();				
		}


		PassagerStandard ron = new PassagerStandard("Ron",10);
		FauxBusVide coquecigrue = new FauxBusVide();
		try
		{	
			ron.monterDans(coquecigrue);
			assertFalse(ron.estDehors());
		}

		catch(UsagerInvalideException e)
		{
			e.printStackTrace();				
		}


		PassagerStandard neuville = new PassagerStandard("Neuville",10);
		FauxBusAssis trevor = new FauxBusAssis();
		try
		{	
			neuville.monterDans(trevor);
			assertFalse(neuville.estDehors());
		}

		catch(UsagerInvalideException e)
		{
			e.printStackTrace();				
		}



	}

}