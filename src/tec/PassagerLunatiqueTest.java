package tec;

import static org.junit.Assert.*;

import org.junit.Test;

public class PassagerLunatiqueTest extends PassagerAbstraitTest
{

	protected PassagerAbstrait creerPassager(String nom, int destination)
	{
		PassagerAbstrait pS = new PassagerLunatique(nom,destination); 
		return pS;
	}

	@Test
	public PassagerLunatiqueTest(String nomPassager, int numeroArret)
	{
		super(nomPassager,numeroArret); 

	}



	@Test
	public void testChoixChangerPlaceTest(Bus bus, int numeroArret)
	{
		
		if (bus instanceof Autobus)
		{
			if (this.estAssis())
			{
				if (((Autobus)bus).aPlaceDebout()) ((Autobus)bus).demanderPlaceDebout(this);
			}
			else if(this.estDebout())
			{
			if (((Autobus)bus).aPlaceAssise()) ((Autobus)bus).demanderPlaceAssise(this);
			}	  
		}
	}
		
	
	public void testChoixPlaceMontee(Transport t)
	{
		if (t instanceof Autobus)
		{
			if (  ((Autobus)t).aPlaceDebout()  )
			{
				((Autobus)t).demanderPlaceDebout(this) ;
			}
		}
	}
}
