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
		  assertEquals("Kaylee",Kaylee.nom());
		  assertFalse("Jayne".equals(Kaylee.nom()));
	  }
	  
	  
	  
	  @Test
	  public void testEstDehors()
	  {
		 Jayne.accepterPlaceAssise();
		 Inara.accepterPlaceDebout();
		 
		 assertTrue(Kaylee.estDehors());
		 assertFalse(Jayne.estDehors());
		 assertFalse(Inara.estDehors());
	  }	  
	  
	
	  
	  @Test
	  public void testEstAssis()
	  {
		  Jayne.accepterPlaceAssise();
		  Inara.accepterPlaceDebout();
		  
		  assertFalse(Kaylee.estAssis());
		  assertTrue(Jayne.estAssis());
		  assertFalse(Inara.estAssis());
		  
	  }
	    
	  
	  
	  @Test
	  public void testEstDebout()
	  {
		  Jayne.accepterPlaceAssise();
		  Inara.accepterPlaceDebout();
		  
		  assertFalse(Kaylee.estDebout());
		  assertFalse(Jayne.estDebout());
		  assertTrue(Inara.estDebout());
	  }
	  
	  
	  
	  @Test
	  public void testAccepterSortie()
	  {
		  Kaylee.accepterPlaceAssise();
		  Jayne.accepterSortie();
		  Inara.accepterPlaceDebout();
		  
		  assertFalse(Kaylee.estDehors());
		  assertTrue(Jayne.estDehors());
		  assertFalse(Inara.estDehors());
		  
	  }
	  
	  
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
