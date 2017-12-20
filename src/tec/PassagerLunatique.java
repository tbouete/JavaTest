package tec;

public final class PassagerLunatique extends PassagerAbstrait
{	

	public PassagerLunatique(String nomPassager, int numeroArret)
	{
		super(nomPassager,numeroArret); 

	}



	
	public void choixChangerPlace(Bus bus, int numeroArret)
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
		
	
	public void choixPlaceMontee(Transport t)
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