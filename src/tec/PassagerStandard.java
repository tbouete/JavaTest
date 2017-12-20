package tec;


public final class PassagerStandard extends PassagerAbstrait
{	

	public PassagerStandard(String nomPassager, int numeroArret)
	{
		super(nomPassager,numeroArret); 

	}



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
	
	
	public void choixChangerPlace(Bus bus, int numeroArret)
	{
		if (bus instanceof Autobus)
		{
			
		}
	}
		



}
