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
	public PassagerStandard(String nomPassager, int numeroArret)
	{
		super(nomPassager,numeroArret); 

	}

	@Test
	public void choixPlaceMontee(Transport t)
	{
		if (t instanceof Autobus)
		{
			if (  ((Autobus)t).aPlaceAssise()  )
			{
				((Autobus)t).demanderPlaceAssise(this);
			}
			else if (  ((Autobus)t).aPlaceDebout()  )
			{
				((Autobus)t).demanderPlaceDebout(this) ;
			}
		}
	}
	
	@Test
	public void choixChangerPlace(Bus bus, int numeroArret)
	{
		if (bus instanceof Autobus)
		{
			
		}
	}

}