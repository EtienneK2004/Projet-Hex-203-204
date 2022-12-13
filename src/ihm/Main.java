package ihm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Scanner;

import plateau.Plateau;
import regles.Hex;

public class Main {
	private static Hex jeu;
	private static final int TAILLE=4;
	
	
	public static void main(String[] args) {
		jeu = new Hex(TAILLE);
		boolean cond = false; //C'est pour test
		Scanner sc = new Scanner(System.in);
		
		while(cond == false) {
			String s = sc.next();
			jeu.jouerCoup(s);
			System.out.println(jeu.getPlateau());
			if (jeu.gagnant(s)!=0) {
				cond = true;
			}
		}
		
		sc.close();
	}

}
