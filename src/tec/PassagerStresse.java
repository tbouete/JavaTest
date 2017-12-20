package tec;

public final class PassagerStresse extends PassagerAbstrait
{	

	public PassagerStresse(String nomPassager, int numeroArret)
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
		}
	}
	
	
	
	public void choixChangerPlace(Bus bus, int numeroArret)
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