package tec;


import tec.EtatPassager.Etat;

public class PassagerStandard extends PassagerAbstrait
{	

	public PassagerStandard(String nomPassager, int numeroArret, int typePass)
	{
		super(nomPassager,numeroArret,typePass); 
		
	}
		  
	
	  
	  /**
	   * Indique au passager qu'il est arrivé à un nouvel arrêt. Cette methode
	   * fixe le comportement (changer de place ou sortir). 
	   * Cette méthode est appelée par Bus.
	   *
	   * @param bus le bus dans lequel se trouve le passager.
	   * @param numeroArret numero de l'arrêt.
	   */
	
	
	
	  public void nouvelArret(Bus bus, int numeroArret)
	  {
		  if (numeroArret == this.getDestination());
		  {
			  ((Autobus)bus).demanderSortie(this);
		  }		  
	  }

	  
	  
	  
	  /**
	   * Fournit à l'usager le transport auquel il peut accéder.
	   * Cette méthode réalise le caractère du passager à la montée.
	   * 
	   * @param t le transport dans lequel désire monter l'usager.
	   * @throws si l'état de l'usager est incohérent par rapport à sa demande.
	   */

	  public void monterDans(Transport t) throws UsagerInvalideException
	  {
		  if (t instanceof Autobus)
		  {
			  ((Autobus)t).demanderPlaceAssise(this);
			  if (this.estDehors())
			  {
				  ((Autobus)t).demanderPlaceDebout(this);
			  }
			  else if(this.estDehors())
			 {
				  throw new UsagerInvalideException ("Il n'y a plus de place disponible.");
			 }
		  }
		  
	  }

	

}
