package tec;

import static org.junit.Assert.*;

import org.junit.Test;

public class AutobusTest {

	private Autobus petitBus = new Autobus(5,10);
	private Autobus moyenBus = new Autobus(10,15);

	@Test
	public void AutobusTest(){
		assertTrue(petitBus.getArretActuel() == 0);
		assertTrue(petitBus.getListPassagers().size() == 0);
		assertTrue(petitBus.getNbPlacesAssises().getMax() == 5);
		assertTrue(petitBus.getNbPlacesDebout().getMax() == 10);

		assertTrue(moyenBus.getNbPlacesAssises().getMax() == 10);
		assertTrue(moyenBus.getNbPlacesDebout().getMax() == 15);
	}

	@Test
	public void allerArretSuivantTest(){
		try{
			petitBus.allerArretSuivant();
		}catch (UsagerInvalideException e) {
			e.printStackTrace();
			fail();
		}

		for(int i = 0; i <= moyenBus.getARRET_FINAL()+1; i++){
			try{
				moyenBus.allerArretSuivant();
				if(moyenBus.getArretActuel() > moyenBus.getARRET_FINAL()) fail();
			}catch (UsagerInvalideException e) {
			}
		}
	}

	@Test
	public void aPlaceAssiseTest(){
		assertTrue(petitBus.aPlaceAssise());

		for(int i = 0; i < petitBus.getNbPlacesAssises().getMax(); i++){
			PassagerStandard bob = new PassagerStandard("Bob" + i, 5);
			petitBus.demanderPlaceAssise(bob);
		}

		assertFalse(petitBus.aPlaceAssise());
	}

	@Test
	public void aPlaceDeboutTest(){
		assertTrue(petitBus.aPlaceDebout());

		for(int i = 0; i < petitBus.getNbPlacesDebout().getMax(); i++){
			PassagerStandard bob = new PassagerStandard("Bob" + i, 5);
			petitBus.demanderPlaceDebout(bob);
		}

		assertFalse(petitBus.aPlaceDebout());
	}

	@Test
	public void demanderPlaceAssiseTest(){
		long nbPlacesDebut = petitBus.getNbPlacesAssises().getValeur();
		PassagerStandard bobLeRetour = new PassagerStandard("BobLeRetour", 5);
		petitBus.demanderPlaceAssise(bobLeRetour);
		assertTrue(bobLeRetour.estAssis());
		assertTrue(petitBus.getNbPlacesAssises().getValeur() == nbPlacesDebut+1);
		
		for(int i = 0; i <= moyenBus.getNbPlacesAssises().getMax(); i++){
			PassagerStandard bobLeRetour2 = new PassagerStandard("BobLeRetour"+i, 5);
			moyenBus.demanderPlaceAssise(bobLeRetour2);
		}
		
		PassagerStandard bobLeRetour3 = new PassagerStandard("BobLeRetour3LeVrai", 5);
		assertTrue(moyenBus.getNbPlacesAssises().getValeur() >= petitBus.getNbPlacesAssises().getMax());
		assertFalse(bobLeRetour3.estAssis());
	}
	
	public void demanderPlaceDeboutTest(){
		long nbPlacesDebut = petitBus.getNbPlacesDebout().getValeur();
		PassagerStandard patrickLeAller = new PassagerStandard("PatrickLeAller", 5);
		petitBus.demanderPlaceDebout(patrickLeAller);
		assertTrue(patrickLeAller.estDebout());
		assertTrue(petitBus.getNbPlacesDebout().getValeur() == nbPlacesDebut+1);
		
		for(int i = 0; i <= moyenBus.getNbPlacesDebout().getMax(); i++){
			PassagerStandard patrickLeRetour = new PassagerStandard("PatrickLeRetour"+i, 5);
			moyenBus.demanderPlaceDebout(patrickLeRetour);
		}
		
		PassagerStandard bobLeRetour3 = new PassagerStandard("BobLeRetour3LeVrai", 5);
		assertTrue(moyenBus.getNbPlacesDebout().getValeur() >= petitBus.getNbPlacesDebout().getMax());
		assertFalse(bobLeRetour3.estDebout());
	}
	
	@Test
	public void demanderChangerEnDeboutTest(){
		PassagerStandard GaryLeDebout = new PassagerStandard("GaryLeDebout", 5);
		PassagerStandard GaryLeAssis = new PassagerStandard("GaryLeAssis", 5);
		
		petitBus.demanderPlaceAssise(GaryLeAssis);
		petitBus.demanderPlaceDebout(GaryLeDebout);
		petitBus.demanderChangerEnDebout(GaryLeAssis);
		
		assertTrue(petitBus.getNbPlacesAssises().getValeur() == 0);
		assertTrue(petitBus.getNbPlacesDebout().getValeur() == 2);
	}
	
	@Test
	public void demanderChangerEnAssisTest(){
		PassagerStandard CarloLeDebout = new PassagerStandard("CarloLeDebout", 5);
		PassagerStandard CarloLeAssis = new PassagerStandard("CarloLeAssis", 5);
		
		petitBus.demanderPlaceAssise(CarloLeAssis);
		petitBus.demanderPlaceDebout(CarloLeDebout);
		petitBus.demanderChangerEnAssis(CarloLeDebout);
		
		assertTrue(petitBus.getNbPlacesAssises().getValeur() == 2);
		assertTrue(petitBus.getNbPlacesDebout().getValeur() == 0);
	}
	
	@Test
	public void demanderDebout(){
		PassagerStandard MKrabsLeDehors = new PassagerStandard("MKrabsLeDehors", 5);
		PassagerStandard MKrabsLeAssis = new PassagerStandard("MKrabsLeDehors", 5);
		PassagerStandard MKrabsLeDebout = new PassagerStandard("MKrabsLeDehors", 5);
		
		petitBus.demanderPlaceAssise(MKrabsLeAssis);
		petitBus.demanderPlaceDebout(MKrabsLeDebout);
		
		petitBus.demanderSortie(MKrabsLeDehors);
		petitBus.demanderSortie(MKrabsLeAssis);
		petitBus.demanderSortie(MKrabsLeDebout);

		assertTrue(petitBus.getNbPlacesAssises().getValeur() == 0);
		assertTrue(petitBus.getNbPlacesDebout().getValeur() == 0);
	}
}
