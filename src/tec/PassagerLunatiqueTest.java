package tec;

import static org.junit.Assert.*;

import org.junit.Test;

public class PassagerLunatiqueTest extends PassagerAbstraitTest
{
	PassagerAbstrait Chris = creerPassager("Chris", 5);
	PassagerAbstrait Bobbi = creerPassager("Bobbi", 4);

	protected PassagerAbstrait creerPassager(String nom, int destination)
	{
		PassagerAbstrait pS = new PassagerLunatique(nom,destination); 
		return pS;
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
					if (i%2 !=0 )
					{
						assertTrue(Chris.estAssis());
					}
					else
					{
						assertTrue(Chris.estDebout());
					}
				}
				catch (UsagerInvalideException e)
				{
					e.printStackTrace();
					fail();
				}
			}

		}
		catch (UsagerInvalideException e)
		{
			e.printStackTrace();
			fail();
		}





	}

	@Test
	public void testChoixPlaceMontee()
	{
		Autobus Zarbibus = new Autobus(15,15);

		try
		{
			Bobbi.monterDans(Zarbibus);

			assertTrue(Bobbi.estDebout());
			assertFalse(Bobbi.estAssis());
			assertFalse(Bobbi.estDehors());

		}
		catch (UsagerInvalideException e)
		{
			e.printStackTrace();
			fail();
		}

	}
}
