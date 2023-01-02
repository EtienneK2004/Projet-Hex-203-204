package ihm;



import java.util.Scanner;

import ia.IAHex;
import regles.Hex;

public class Main {
	private static Hex jeu;
	private static int taille;
	private static String[] joueurs;
	private static String reponse;
	private static int[] bordMax = {1, 26}; 
	
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
		
		do {
			System.out.println(IHMStrings.DmdTaille);
			taille = sc.nextInt();
		} while(taille < bordMax[0] && taille > bordMax[1]);
		
		System.out.println(IHMStrings.NomJoueur1);
		joueurs[0] = sc.next();
		System.out.println(IHMStrings.NomJoueur2);
		joueurs[1] = sc.next();
	}
	
	private static void jouer(Scanner sc) {
		jeu = new Hex(taille);
		boolean finie = false;
		while(finie == false) {
			if (finie = tour(sc)) {
				System.out.println(jeu);
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
	
	private static boolean isIA(String joueur) {
		return joueurs[jeu.getJoueur()].matches("[0-9]+");
	}
	
	private static boolean tour(Scanner sc) {
		System.out.println(jeu);
		if(!isIA(joueurs[jeu.getJoueur()]))
			System.out.println(joueurs[jeu.getJoueur()] + IHMStrings.Jouer);
		boolean valide = false;
		String coup = "";
		while(!valide) {
			
			
			
			if(isIA(joueurs[jeu.getJoueur()])) {
				int IANum = Integer.parseInt(joueurs[jeu.getJoueur()]);
				IAHex ia = IAHex.getIA(IANum);
				coup = ia.getCoup(jeu.getPlateau());
			}
			else {
				coup = sc.next();
			}
			valide = jeu.estValide(coup);
			if(!valide) System.out.println(IHMStrings.CaseInvalide);
		}
		if(isIA(joueurs[jeu.getJoueur()]))
			System.out.println(IHMStrings.joueIA + coup);
		jeu.jouerCoup(coup);
		
		return jeu.gagnant() == jeu.getJoueur();
	}

}
