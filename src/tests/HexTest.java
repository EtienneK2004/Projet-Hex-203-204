package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import plateau.Plateau;
import regles.Hex;

class HexTest {

	@Test
	void test() {
		Hex hex = new Hex(5);
		hex.jouerCoup("A1");
		hex.jouerCoup("B2");
		hex.jouerCoup("C3");
		assertTrue(hex.estValide("D2"));
		hex.jouerCoup("D2");
		assertFalse(hex.estValide("D2"));
		hex.jouerCoup("E4");
		hex.jouerCoup("E5");
		assertEquals(new Plateau(5, hex.getPlateau()).toString(), hex.toString());
		assertFalse(hex.estValide("H6"));
	}

}
