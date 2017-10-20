package JaugeTest;

import org.junit.Test;

public class JaugeNaturelTest {
	
	JaugeNaturel jaugeVerte = new JaugeNaturel(0, 5, 2);
	JaugeNaturel jaugeRouge = new JaugeNaturel(0, 5, 6);
	JaugeNaturel jaugeBleue = new JaugeNaturel(0, 5, -2);
	
	@Test
	public void testEstVert(){
		assert jaugeVerte.estVert() : "ma jaugeVerte doit être verte";
		assert !jaugeRouge.estVert() : "ma jaugeRouge ne doit pas être verte ";
		assert !jaugeBleue.estVert() : "ma jaugeBleue ne doit pas être verte ";
		assert !new JaugeNaturel(0, 5, 0).estVert() : "une jauge à la limite inférieure ne doit pas être verte";
		assert !new JaugeNaturel(0, 5, 5).estVert() : "une jauge à la limite suppérieure ne doit pas être verte";
	}
	
	@Test
	public void testEstBleu(){
		assert !jaugeVerte.estBleu() : "ma jaugeVerte ne doit pas être bleue";
		assert !jaugeRouge.estBleu() : "ma jaugeRouge ne doit pas être bleue ";
		assert jaugeBleue.estBleu() : "ma jaugeBleue doit être bleue ";
		assert new JaugeNaturel(0, 5, 0).estBleu() : "une jauge à la limite inférieure doit être bleue";
		assert !new JaugeNaturel(0, 5, 5).estBleu() : "une jauge à la limite suppérieure ne doit pas être bleue";
	}
	
	@Test
	public void testEstRouge(){
		assert !jaugeVerte.estRouge() : "ma jaugeVerte ne doit pas être rougee";
		assert jaugeRouge.estRouge() : "ma jaugeRouge doit être rouge";
		assert !jaugeBleue.estRouge() : "ma jaugeBleue ne doit pas être rouge ";
		assert !new JaugeNaturel(0, 5, 0).estRouge() : "une jauge à la limite inférieure ne doit pas être rouge mais bleue";
		assert new JaugeNaturel(0, 5, 5).estRouge() : "une jauge à la limite suppérieure doit être rouge";
	}
	
}
