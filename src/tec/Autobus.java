package tec;

import java.util.ArrayList;
import java.util.List;

import tec.JaugeNaturel;

public class Autobus implements Transport, Bus
{
	private final int ARRET_FINAl = 10;
	private int arretActuel = 0;
	private JaugeNaturel nbPlacesAssises;
	private JaugeNaturel nbPlacesDebout;
	private List<Passager> listPassagers;
	
	public Autobus(int nbPlacesAssisesMax, int nbPlacesDeboutsMax){
		this.listPassagers = new ArrayList<>();
		this.nbPlacesAssises = new JaugeNaturel(0, nbPlacesAssisesMax, 0);
		this.nbPlacesDebout = new JaugeNaturel(0, nbPlacesDeboutsMax, 0);
	}
	
	public Autobus(int placeAssisesEtDebout){ this(placeAssisesEtDebout, placeAssisesEtDebout); }
	
	public Autobus() { this(0, 0); }
	

	public void allerArretSuivant() throws UsagerInvalideException
	{
		if(arretActuel + 1 == this.ARRET_FINAl) throw new UsagerInvalideException("Cet autobus est d�j� au terminus");
		this.arretActuel++;
		for(int i = 0; i < listPassagers.size() ; i++) 
		{
			this.listPassagers.get(i).nouvelArret(this, this.arretActuel);
		}
	}
	
	
	  /**
	   * vrai s'il existe des places assises.
	   * @return vrai s'il existe des places assises
	   */
	  public boolean aPlaceAssise(){ return !this.nbPlacesAssises.estRouge(); }

	  
	  
	  
	  
	  /**
	   * vrai s'il existe des places debouts.
	   * @return vrai s'il existe des places debouts
	   */
	  public boolean aPlaceDebout(){ return !this.nbPlacesDebout.estRouge(); }

	  
	  
	  
	  
	  /**
	   * Le passager entre dans ce bus en demandant une place assise.
	   * L'état du passager est forcément dehors.
	   * Cette méthode est appelée par Passager.
	   * @param p le passager
	   */
	  
	  public void demanderPlaceAssise(Passager p)
	  {
		  if (p instanceof PassagerStandard) 
		  {
			  PassagerStandard pS = (PassagerStandard) p;
			  if(this.aPlaceAssise())
			  {
				  pS.accepterPlaceAssise();
				  this.nbPlacesAssises.incrementer();
				  this.listPassagers.add(pS);
			  }
		  }
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
		  if (p instanceof PassagerStandard) {
			  PassagerStandard pS = (PassagerStandard) p;
			  if(this.aPlaceDebout()){
				  pS.accepterPlaceDebout();
				  this.nbPlacesDebout.incrementer();
				  this.listPassagers.add(pS);
			  }
		  }
	  }


	  
	  
	  
	  
	  /**
	   * Change un passager d'une place assise vers une place debout.
	   * Elle change l'état du passager.
	   * @param p le passager avec un état assis.
	   */
	  public void demanderChangerEnDebout(Passager p)
	  {
		  if (p instanceof PassagerStandard) {
				PassagerStandard pS = (PassagerStandard) p;
				if(this.aPlaceDebout()){
					pS.accepterPlaceDebout();
					this.nbPlacesAssises.decrementer();
					this.nbPlacesDebout.incrementer();
				}
		  }
	  }

	  
	  
	  
	  
	  
	  /**
	   * Change un passager d'une place debout vers une place assise.
	   * Elle change l'état du passager.
	   * @param p le passager avec un état debout.
	   */
	  public void demanderChangerEnAssis(Passager p)
	  {
		  if (p instanceof PassagerStandard) {
				PassagerStandard pS = (PassagerStandard) p;
				if(this.aPlaceAssise()){
					pS.accepterPlaceAssise();
					this.nbPlacesAssises.incrementer();
					this.nbPlacesDebout.decrementer();
		  }
		  }
	  }

	  
	  
	  
	  /**
	   * Fait sortir un passager du bus.
	   * Elle change l'état du passager.
	   * @param p le passager avec un état soit assis soit debout.
	   */
	  public void demanderSortie(Passager p)
	  {
		  if(this.listPassagers.contains(p)) this.listPassagers.remove(p);
		  if (p instanceof PassagerStandard) {
			PassagerStandard pS = (PassagerStandard) p;
			if(pS.monEtat.estDebout()){ this.nbPlacesDebout.decrementer(); }
			if(pS.monEtat.estAssis()){ this.nbPlacesAssises.decrementer(); }
		  	pS.accepterSortie();
		  }
	  }

	@Override
	public String toString() {
		String ret = "";
		ret += "Nombres de passagers assis : " + this.nbPlacesAssises.getValeur() + "/." + this.nbPlacesAssises.getMax() + "\n";
		ret += "Nombres de passagers debout : " + this.nbPlacesDebout.getValeur() + "/." + this.nbPlacesDebout.getMax() + "\n";
		ret += "Arret actuel :" + this.arretActuel;
		return ret;
	}

	public int getArretActuel() {
		return arretActuel;
	}

	public JaugeNaturel getNbPlacesAssises() {
		return nbPlacesAssises;
	}

	public JaugeNaturel getNbPlacesDebout() {
		return nbPlacesDebout;
	}

	public List<Passager> getListPassagers() {
		return listPassagers;
	}

	public int getARRET_FINAL(){
		return ARRET_FINAl;
	}
	
	  

	  
}
