package ihm;



import java.util.Scanner;

import regles.Hex;

public class Main {
	private static Hex jeu;
	private static final int TAILLE=4;
	private static String[] joueurs;
	private static String reponse;
	
	public static void main(String[] args) {
		joueurs = new String[2]; 
		Scanner sc = new Scanner(System.in);
		debut(sc);
		jouer(sc);
		sc.close();
	}
	
	private static void debut(Scanner sc) {
		System.out.println(IHMStrings.Bienvenue);
		System.out.println(IHMStrings.DmdRegle);
		reponse = sc.next().toUpperCase();
		if(reponse.equals(IHMStrings.SaisieOui.toString()))
		{
			System.out.println(IHMStrings.Regle);
			System.out.println(IHMStrings.DmdRegle1);
			reponse = sc.next().toUpperCase();
			if(reponse.equals(IHMStrings.SaisieOui.toString())) 
			{
				System.out.println(IHMStrings.Regle1);
				System.out.println(IHMStrings.Regle2);
				System.out.println(IHMStrings.Regle3);
			}
		}
		System.out.println(IHMStrings.NomJoueur1);
		joueurs[0] = sc.next();
		System.out.println(IHMStrings.NomJoueur2);
		joueurs[1] = sc.next();

	}
	
	private static void jouer(Scanner sc) {
		jeu = new Hex(TAILLE);
		boolean noGagnant = false;
		while(noGagnant == false) {
			if (noGagnant = tour(sc)) {
				System.out.println(joueurs[(jeu.getJoueur() + 1) % joueurs.length] + IHMStrings.Gagne);
				System.out.println(IHMStrings.Recommencer);
				reponse = sc.next().toUpperCase();
				if(reponse.equals(IHMStrings.SaisieOui.toString()))
					recommencer(sc);
			}
		}
	}
	
	private static void recommencer(Scanner sc) {
		String change;
		change = joueurs[0];
		joueurs[0]=joueurs[1];
		joueurs[1]=change;
		jouer(sc);
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
