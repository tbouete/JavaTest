package tec;

import tec.EtatPassager;
import tec.EtatPassager.Etat;

public class PassagerStandard implements Passager, Usager
{
	
	public String nom;
	public int destination;
	public EtatPassager monEtat;
	

	public PassagerStandard(String nomPassager, int numeroArret)
	{
		Etat e = EtatPassager.Etat.DEHORS;
		this.nom = nomPassager;
		this.destination = numeroArret;
		this.monEtat = new EtatPassager(e);
	}
		  
	  
	  public String nom()
	  {
		  return this.nom;
	  }
	  
	  
	  
	  /**
	   * Retourne vrai si le passager est hors du bus.
	   * @return vrai si le passager est hors du bus.
	   */
	  public boolean estDehors()
	  {
		 return this.monEtat.estExterieur();
	  }	  
	  
	
	  
	  /**
	   * Retourne vrai si le passager est assis dans le bus.
	   * @return vrai si le passager est assis dans le bus.
	   */
	  public boolean estAssis()
	  {
		  return this.monEtat.estAssis();
	  }
	    
	  
	  
	  /**
	   * Retourne vrai si le passager est debout dans le bus.
	   * @return vrai si le passager est debout dans le bus.
	   */
	  public boolean estDebout()
	  { 
		  return this.monEtat.estDebout();
		  
	  }
	  
	  
	  
	  /**
	   * Change l'�tat du passager en hors du bus.
	   * Cette m�thode est appel�e par un objet Bus.
	   */
	  public void accepterSortie()
	  {
		  this.monEtat = new EtatPassager(EtatPassager.Etat.DEHORS);
	  }
	  
	  
	  
	  
	  /**
	   * Change l'état du passager en assis. 
	   * Le passager est dans le bus.
	   * Cette méthode est appelée par un objet Bus.
	   */
	  public void accepterPlaceAssise()
	  {
		  this.monEtat = new EtatPassager(EtatPassager.Etat.ASSIS);
	  }
	  
	  
	  
	  
	  /**
	   * Change l'état du passager en debout.
	   * Le passager est dans le bus.
	   * Cette méthode est appelée par un objet Bus.
	   */
	  public void accepterPlaceDebout()
	  {
		  this.monEtat = new EtatPassager(EtatPassager.Etat.DEBOUT);		  
		  
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
		  if (numeroArret == this.destination)
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


	@Override
	public String toString() {
		return new String("Le passager " + this.nom + " est actuellement " + this.monEtat + " et descend � l'arret n�" + this.destination);
	}

	

}
