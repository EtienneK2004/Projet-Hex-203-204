package regles;

import plateau.Plateau;
import plateau.Pion;

public class Hex {
	private Plateau p;
	
	public Hex(int taille) {
		p = new Plateau(taille);
		//TODO
	}
	
	//Le joueur est implicite et géré par le plateau
	public void jouerCoup(String coord) throws IllegalArgumentException{
		if(!estValide(coord)) throw new IllegalArgumentException();
		p.jouer(coord);
	}
	
	public boolean estValide(String coord) {
		return p.estValide(coord) && p.getCase(coord)==Pion.Vide;
	}
	
	public int gagnant(String coord) {
		return p.gagnant(coord);
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
