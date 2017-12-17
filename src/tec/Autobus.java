package tec;

public class Autobus implements Transport, Bus
{

	public Autobus() {
		// TODO Auto-generated constructor stub
	}

	public void allerArretSuivant() throws UsagerInvalideException
	{
		
	}
	
	
	  /**
	   * vrai s'il existe des places assises.
	   * @return vrai s'il existe des places assises
	   */
	  public boolean aPlaceAssise()
	  {
		  boolean wesh = false;
		  return false;
	  }

	  
	  
	  
	  
	  /**
	   * vrai s'il existe des places debouts.
	   * @return vrai s'il existe des places debouts
	   */
	  public boolean aPlaceDebout()
	  { 
		  boolean wesh = false;
		  return false;
		  
	  }

	  
	  
	  
	  
	  /**
	   * Le passager entre dans ce bus en demandant une place assise.
	   * L'état du passager est forcément dehors.
	   * Cette méthode est appelée par Passager.
	   * @param p le passager
	   */
	  public void demanderPlaceAssise(PassagerStandard p)
	  {
		  
	  }
	  
	  
	  
	  
	  
	  
	  
	  /**
	   * Le passager entre dans ce bus en demandant une place debout.
	   * L'état du passager est forcément dehors.
	   * Cette méthode est appelée par passager. 
	   * Elle change l'état du passager.
	   * @param p le passager
	   */
	  public void demanderPlaceDebout(Passager p)
	  {
		  
	  }


	  
	  
	  
	  
	  /**
	   * Change un passager d'une place assise vers une place debout.
	   * Elle change l'état du passager.
	   * @param p le passager avec un état assis.
	   */
	  public void demanderChangerEnDebout(Passager p)
	  {
		  
	  }

	  
	  
	  
	  
	  
	  /**
	   * Change un passager d'une place debout vers une place assise.
	   * Elle change l'état du passager.
	   * @param p le passager avec un état debout.
	   */
	  public void demanderChangerEnAssis(Passager p)
	  {
		  
	  }

	  
	  
	  
	  /**
	   * Fait sortir un passager du bus.
	   * Elle change l'état du passager.
	   * @param p le passager avec un état soit assis soit debout.
	   */
	  public void demanderSortie(Passager p)
	  {
		  
	  }
	  
	  
}
