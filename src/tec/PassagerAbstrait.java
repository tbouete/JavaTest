package tec;

import tec.EtatPassager.Etat;

public abstract class PassagerAbstrait implements Passager, Usager

{

	private String nom;
	private int destination;
	private EtatPassager monEtat;
	private int typePassager;


	public PassagerAbstrait(String nomPassager, int numeroArret, int typePass)
	{
		Etat e = EtatPassager.Etat.DEHORS;
		this.nom = nomPassager;
		this.destination = numeroArret;
		this.monEtat = new EtatPassager(e);		
		this.typePassager = typePass;
	}

	
	public String getNom() {return nom;}
	public void setNom(String nom) {this.nom = nom;}
	
	public int getDestination() {return destination;}
	public void setDestination(int destination) {this.destination = destination;}

	public EtatPassager getMonEtat() {return monEtat;}
	public void setMonEtat(EtatPassager monEtat) {this.monEtat = monEtat;}

	public int getTypePassager() {return typePassager;}
	public void setTypePassager(int typePassager) {this.typePassager = typePassager;}



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
	 * 
	 * A REDEFINIR
	 */
	public abstract void nouvelArret(Bus bus, int numeroArret);




	/**
	 * Fournit à l'usager le transport auquel il peut accéder.
	 * Cette méthode réalise le caractère du passager à la montée.
	 * 
	 * @param t le transport dans lequel désire monter l'usager.
	 * @throws si l'état de l'usager est incohérent par rapport à sa demande.
	 *
	 *A REDEFINIR
	 *
	 */

	public abstract void monterDans(Transport t) throws UsagerInvalideException;



}