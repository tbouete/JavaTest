package tec;

import static org.junit.Assert.*;

import org.junit.Test;

public class PassagerStresseTest
{
	
	protected PassagerAbstrait creerPassager(String nom, int destination)
	{
		PassagerAbstrait pS = new PassagerStresse(nom,destination); 
		return pS;
	}
	
	

	@Test
	public testPassagerStresse(String nomPassager, int numeroArret)
	{
		super(nomPassager,numeroArret); 

	}



	public void testChoixPlaceMontee(Transport t)
	{
		if (t instanceof Autobus)
		{
			if (  ((Autobus)t).aPlaceAssise()  )
			{
				((Autobus)t).demanderPlaceAssise(this);
			}
		}
	}
	
	
	@Test
	public void testChoixChangerPlace(Bus bus, int numeroArret)
	{
		if (bus instanceof Autobus)
		{
			if (numeroArret == this.getDestination()-3 );
			{
				if (((Autobus)bus).aPlaceDebout()) ((Autobus)bus).demanderPlaceDebout(this);
			}
		}
	}
		
}
