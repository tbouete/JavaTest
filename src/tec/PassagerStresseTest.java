package tec;

import static org.junit.Assert.*;

import org.junit.Test;

public class PassagerStresseTest
{
	PassagerAbstrait Chris = creerPassager("Chris", 5);
	PassagerAbstrait Bobbi = creerPassager("Bobbi", 4);



	protected PassagerAbstrait creerPassager(String nom, int destination)
	{
		PassagerAbstrait pS = new PassagerStresse(nom,destination); 
		return pS;
	}





	public void testChoixPlaceMontee()
	{
		Autobus Zarbibus = new Autobus(15,15);

		try
		{
			Bobbi.monterDans(Zarbibus);

			assertFalse(Bobbi.estDebout());
			assertTrue(Bobbi.estAssis());
			assertFalse(Bobbi.estDehors());

		}
		catch (UsagerInvalideException e)
		{
			e.printStackTrace();
			fail();
		}

	}


	@Test
	public void testChoixChangerPlace()
	{
		Autobus Busbizarre = new Autobus(15,15);

		try
		{
			Chris.monterDans(Busbizarre);
			assertTrue(Chris.estAssis());
			assertFalse(Chris.estDebout());
			assertFalse(Chris.estDehors());


			for(int i=0 ; i<4 ; i++)
			{
				try
				{
					Busbizarre.allerArretSuivant();
				}
				catch (UsagerInvalideException e)
				{
					e.printStackTrace();
					fail();
				}
			}

			assertFalse(Chris.estAssis());
			assertTrue(Chris.estDebout());
			assertFalse(Chris.estDehors());


		}
		catch (UsagerInvalideException e)
		{
			e.printStackTrace();
			fail();
		}


	}

}
