package etatPassager;

import static org.junit.Assert.*;

import org.junit.Test;

import etatPassager.EtatPassager.Etat;

public class IEtatPassagerTest {

	private IEtatPassager creerAssis(EtatPassagerTypes type) throws IllegalArgumentException{
		IEtatPassager ret;
		
		switch(type){
		case EtatPassager : ret = new EtatPassager(etatPassager.EtatPassager.Etat.ASSIS); break;
		case EtatPassagerChaine : ret = new EtatPassagerChaine(etatPassager.EtatPassagerChaine.Etat.ASSIS); break;
		default : throw new IllegalArgumentException();
		}
		
		return ret;
	}
	
	private IEtatPassager creerDehors(EtatPassagerTypes type)throws IllegalArgumentException{
		IEtatPassager ret;
		
		switch(type){
		case EtatPassager : ret = new EtatPassager(etatPassager.EtatPassager.Etat.DEHORS); break;
		case EtatPassagerChaine : ret = new EtatPassagerChaine(etatPassager.EtatPassagerChaine.Etat.DEHORS); break;
		default : throw new IllegalArgumentException();
		}
		
		return ret;
	}
	
	private IEtatPassager creerDebout(EtatPassagerTypes type)throws IllegalArgumentException{
		IEtatPassager ret;
		
		switch(type){
		case EtatPassager : ret = new EtatPassager(etatPassager.EtatPassager.Etat.DEBOUT); break;
		case EtatPassagerChaine : ret = new EtatPassagerChaine(etatPassager.EtatPassagerChaine.Etat.DEBOUT); break;
		default : throw new IllegalArgumentException();
		}
		
		return ret;
	}
	
	@Test
	public void testEtatPassager() 
	{
		for(EtatPassagerTypes type : EtatPassagerTypes.values()){
			IEtatPassager etatAssis =  this.creerAssis(type);
			assertNotNull(etatAssis);
		}
		
		for(EtatPassagerTypes type : EtatPassagerTypes.values()){
			IEtatPassager etatDebout =  this.creerDebout(type);
			assertNotNull(etatDebout);
		}
		
		for(EtatPassagerTypes type : EtatPassagerTypes.values()){
			IEtatPassager etatDehors =  this.creerDehors(type);
			assertNotNull(etatDehors);
		}
	}
	
		 
	@Test
	public void testAssis() {
		for(EtatPassagerTypes type : EtatPassagerTypes.values()){
			IEtatPassager etatAssis =  this.creerAssis(type);
			assertTrue(etatAssis.estAssis());
			assertFalse(etatAssis.estDebout());
			assertFalse(etatAssis.estExterieur());
		}
	}

	@Test
	public void testDebout() {
		for(EtatPassagerTypes type : EtatPassagerTypes.values()){
			IEtatPassager etatDebout =  this.creerDebout(type);
			assertFalse(etatDebout.estAssis());
			assertTrue(etatDebout.estDebout());
			assertFalse(etatDebout.estExterieur());
		}
	}
	
	@Test
	public void testExterieur() {	
		for(EtatPassagerTypes type : EtatPassagerTypes.values()){
			IEtatPassager etatDehors =  this.creerDehors(type);
			assertFalse(etatDehors.estAssis());
			assertFalse(etatDehors.estDebout());
			assertTrue(etatDehors.estExterieur());
		}
	}
	
	@Test
	public void testInterieur() {
		for(EtatPassagerTypes type : EtatPassagerTypes.values()){
			IEtatPassager etatAssis =  this.creerAssis(type);
			assertTrue(etatAssis.estInterieur());;
		}
		
		for(EtatPassagerTypes type : EtatPassagerTypes.values()){
			IEtatPassager etatDebout =  this.creerDebout(type);
			assertTrue(etatDebout.estInterieur());;
		}
		
		for(EtatPassagerTypes type : EtatPassagerTypes.values()){
			IEtatPassager etatDehors =  this.creerDehors(type);
			assertTrue(!etatDehors.estInterieur());
		}
	}

}
