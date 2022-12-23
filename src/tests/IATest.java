package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ia.IA;
import plateau.Plateau;

class IATest {

	@Test
	void test() {
		IA ia = new IA();
		String[] ps = {
				"X.OX.OO.XX.OO.X.",
				".XO.XO.O.X.X..OX",
				".OX...O......X..",
				"O.X.O.X.X..OOOXX"
		};
		for(String p : ps) {
			System.out.println(new Plateau(4, p));
			System.out.println(ia.getCoup(p));
		}
		
		int[][] board = new int[][] {
		    {-1, 1, -1, 0},
		    {1, -1, 0, -1},
		    {0, 1, 0, 1},
		    {0, 0, -1, 1}
		};
		
		System.out.println(IA.checkWin(board, -1));
		
	}

}
