package tec;

import static org.junit.Assert.*;

import org.junit.Test;

public class AutobusTest {

	private Autobus petitBus = new Autobus(5,10);
	private Autobus moyenBus = new Autobus(10,15);
	private Autobus grandBus = new Autobus(20, 30);
	
	@Test
	public void AutobusTest(){
		assertTrue(petitBus.getArretActuel() == 0);
		assertTrue(petitBus.getListPassagers().size() == 0);
		assertTrue(petitBus.getNbPlacesAssises().getMax() == 5);
		assertTrue(petitBus.getNbPlacesDebout().getMax() == 10);
		
		assertTrue(moyenBus.getNbPlacesAssises().getMax() == 10);
		assertTrue(moyenBus.getNbPlacesDebout().getMax() == 15);
		
		assertTrue(grandBus.getNbPlacesAssises().getMax() == 20);
		assertTrue(grandBus.getNbPlacesDebout().getMax() == 30);
	}
}
