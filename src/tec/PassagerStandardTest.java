package tec;

import static org.junit.Assert.*;

import org.junit.Test;

import etatPassager.EtatPassager;

public class PassagerStandardTest 
{
	
	PassagerStandard Kaylee = new PassagerStandard("Kaylee", 5);
	PassagerStandard Jayne = new PassagerStandard("Jayne", 4);
	PassagerStandard Inara = new PassagerStandard("Inara", 5);
	
	
	  @Test
	  public void testNom()
	  {
		  assertTrue("Kaylee"==Kaylee.nom());
		  assertEquals("Kaylee",Kaylee.nom());
	  }
	  
	  
//	  
//	  @Test
//	  public boolean testEstDehors()
//	  {
//		 return this.monEtat.estExterieur();
//	  }	  
//	  
//	
//	  
//	  @Test
//	  public boolean testEstAssis()
//	  {
//		  return this.monEtat.estAssis();
//	  }
//	    
//	  
//	  
//	  @Test
//	  public boolean testEstDebout()
//	  { 
//		  return this.monEtat.estDebout();
//		  
//	  }
//	  
//	  
//	  
//	  @Test
//	  public void testAccepterSortie()
//	  {
//		  this.monEtat = new EtatPassager(etatPassager.EtatPassager.Etat.DEHORS);
//	  }
//	  
//	  
//	  
//	  
//	  @Test
//	  public void testAccepterPlaceAssise()
//	  {
//		  this.monEtat = new EtatPassager(etatPassager.EtatPassager.Etat.ASSIS);
//	  }
//	  
//	  
//	  
//	  
//	  @Test
//	  public void testAccepterPlaceDebout()
//	  {
//		  this.monEtat = new EtatPassager(etatPassager.EtatPassager.Etat.DEBOUT);		  
//		  
//	  }
//
//	
//	
//	
//	@Test
//	  public void testNouvelArret(Bus bus, int numeroArret)
//	  {
//		  if (numeroArret == this.destination)
//		  {
//			  ((Autobus)bus).demanderSortie(this);
//		  }		  
//	  }
//
//	  
//	  
//	  
//
//		@Test
//	  public void testMonterDans(Transport t) throws UsagerInvalideException
//	  {
//		  if (t instanceof Autobus)
//		  {
//			  ((Autobus)t).demanderPlaceDebout(this);
//			  if (this.estDehors())
//			  {
//				  ((Autobus)t).demanderPlaceAssise(this);
//			  }
//			  else if(this.estDehors())
//			 {
//				  throw new UsagerInvalideException ("Il n'y a plus de place disponible.");
//			 }
//		  }

}
