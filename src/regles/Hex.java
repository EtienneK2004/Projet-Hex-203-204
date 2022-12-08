package regles;

import plateau.Plateau;

public class Hex {
	private Plateau p;
	
	public Hex(int taille) {
		p = new Plateau(taille);
	}
	
	//Le joueur est implicite et géré par le plateau
	public void jouerCoup(int x, int y) {
		//TODO
	}
	
	public int gagnant() {
		//TODO
		return 0;
	}
	
	public int getVal(int x, int y) {
		//TODO
		return 0;
	}
	
	public String getPlateau() {
		//TODO
		return null;
	}
}
