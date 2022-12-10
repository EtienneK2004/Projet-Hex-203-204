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
		Scanner sc = new Scanner(System.in);
		
		do {
			String s = sc.next();
			jeu.jouerCoup(s);
			System.out.println(jeu.getPlateau());
		}while(jeu.gagnant(s)==0);
		
		sc.close();
	}

}
