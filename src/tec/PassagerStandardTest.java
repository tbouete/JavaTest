package tec;

import static org.junit.Assert.*;

import org.junit.Test;

public class PassagerStandardTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	
	  /**
	   * Test m�thode Nouvel Arret qui doit indique au passager s'il est arrivé à un nouvel arrêt. Cette methode
	   * fixe le comportement (changer de place ou sortir). 
	   * Cette méthode est appelée par Bus.
	   *
	   * @param bus le bus dans lequel se trouve le passager.
	   * @param numeroArret numero de l'arrêt.
	   */
	
	@Test
	  public void testNouvelArret(Bus bus, int numeroArret)
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
		@Test
	  public void monterDans(Transport t) throws UsagerInvalideException
	  {
		  if (t instanceof Autobus)
		  {
			  ((Autobus)t).demanderPlaceDebout(this);
			  if (this.estDehors())
			  {
				  ((Autobus)t).demanderPlaceAssise(this);
			  }
			  else if(this.estDehors())
			 {
				  throw new UsagerInvalideException ("Il n'y a plus de place disponible.");
			 }
		  }

}
