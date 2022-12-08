package regles;

import plateau.Plateau;

public class Hex {
	private Plateau p;
	
	public Hex(int taille) {
		p = new Plateau(taille);
		//TODO
	}
	
	//Le joueur est implicite et géré par le plateau
	public void jouerCoup(String coord) {
		//TODO
	}
	
	public int gagnant() {
		//TODO
		return 0;
	}
	
	public int getVal(String coord) {
		//TODO
		return 0;
	}
	
	public String getPlateau() {
		//TODO
		return null;
	}
}
