package JaugeTest;

import org.junit.Test;

public class JaugeNaturelTest {
	
	JaugeNaturel jaugeVerte = new JaugeNaturel(0, 5, 2);
	JaugeNaturel jaugeRouge = new JaugeNaturel(0, 5, 6);
	JaugeNaturel jaugeBleue = new JaugeNaturel(0, 5, -2);
	
	@Test
	public void testEstVert(){
		assert jaugeVerte.estVert() : "ma jaugeVerte doit �tre verte";
		assert !jaugeRouge.estVert() : "ma jaugeRouge ne doit pas �tre verte ";
		assert !jaugeBleue.estVert() : "ma jaugeBleue ne doit pas �tre verte ";
		assert !new JaugeNaturel(0, 5, 0).estVert() : "une jauge � la limite inf�rieure ne doit pas �tre verte";
		assert !new JaugeNaturel(0, 5, 5).estVert() : "une jauge � la limite supp�rieure ne doit pas �tre verte";
	}
	
	@Test
	public void testEstBleu(){
		assert !jaugeVerte.estBleu() : "ma jaugeVerte ne doit pas �tre bleue";
		assert !jaugeRouge.estBleu() : "ma jaugeRouge ne doit pas �tre bleue ";
		assert jaugeBleue.estBleu() : "ma jaugeBleue doit �tre bleue ";
		assert new JaugeNaturel(0, 5, 0).estBleu() : "une jauge � la limite inf�rieure doit �tre bleue";
		assert !new JaugeNaturel(0, 5, 5).estBleu() : "une jauge � la limite supp�rieure ne doit pas �tre bleue";
	}
	
}
