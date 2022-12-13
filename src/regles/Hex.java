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
	public boolean jouerCoup(String coord) {
		p.jouer(coord);
		return true;
	}
	
	public int gagnant(String coord) {
		return p.gagnant(coord);
	}
	
	public int getVal(String coord) {
		//TODO
		
		return 0;
	}
	
	public String getPlateau() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<p.taille(); i++) {
			for(int j=0; j<p.taille(); j++) {
				sb.append(p.getCase(((char)('A'+i))+""+(j+1)));
			}
		}
		return sb.toString();
	}
	
	public String toString() {
		return p.toString();
	}
}
