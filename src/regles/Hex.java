package regles;

import regles.ilot.GestionIlots;
import plateau.IPlateau;
import plateau.Pion;

public class Hex {
	private IPlateau p;
	private GestionIlots gi;
	
	public Hex(int taille) {
		this.p = IPlateau.getPlateau(taille);
		this.gi = new GestionIlots(taille);
	}
	
	public int getJoueur() {
		return p.getJoueur();
	}
	
	
	public void jouerCoup(String coord) throws IllegalArgumentException{
		if(!estValide(coord)) throw new IllegalArgumentException();
		p.jouer(coord);
		gi.ajouterCase(coord.charAt(0) - 'A', coord.charAt(1) - '1', p.getJoueur());
	}
	
	public boolean estValide(String coord) {
		return p.estValide(coord) && p.getCase(coord) == Pion.Vide;
	}
	/**
	 * Determine le gagnant, 0 pour le joueur 1, 1 pour le joueur 2, -1 si il n'y a pas de gagnant
	 * @return int
	 */
	public int gagnant() {
		return gi.gagnant();
	}
	
	public int getVal(String coord) {
		switch(p.getCase(coord)) {
		case Vide:
			return 0;
		case Croix:
			return 1;
		case Rond:
			return -1;
		}
		return 0;
	}
	
	public String getPlateau() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<p.taille(); i++) {
			for(int j=0; j<p.taille(); j++) {
				sb.append(p.getCase(((char)('A'+j))+""+(i+1)));
			}
		}
		return sb.toString();
	}
	
	public String toString() {
		return p.toString();
	}
	
	
}
