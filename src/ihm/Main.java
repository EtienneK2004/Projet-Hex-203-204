package ihm;



import java.util.Scanner;

import regles.Hex;

public class Main {
	private static Hex jeu;
	private static final int TAILLE=4;
	private static String[] joueurs;
	
	
	
	public static void main(String[] args) {
		jeu = new Hex(TAILLE);
		joueurs = new String[2];
		boolean noGagnant = false; 
		Scanner sc = new Scanner(System.in);
		debut(sc);
		while(noGagnant == false) {
			if (noGagnant = tour(sc)) {
				System.out.println(joueurs[jeu.getJoueur()] + IHMStrings.Gagne);
				System.out.println(IHMStrings.Recommencer);
			}
		}
		
		sc.close();
	}
	
	private static void debut(Scanner sc) {
		System.out.println(IHMStrings.Bienvenue);
		System.out.println(IHMStrings.NomJoueur1);
		joueurs[0] = sc.next();
		System.out.println(IHMStrings.NomJoueur2);
		joueurs[1] = sc.next();
	}
	
	private static boolean tour(Scanner sc) {
		System.out.println(jeu);
		System.out.println(joueurs[jeu.getJoueur()] + IHMStrings.Jouer);
		boolean valide = false;
		String coup = "";
		while(!valide) {
			coup = sc.next();
			valide = jeu.estValide(coup);
			if(!valide) System.out.println(IHMStrings.CaseInvalide);
		}
		jeu.jouerCoup(coup);
		return jeu.gagnant() == jeu.getJoueur();
	}

}
