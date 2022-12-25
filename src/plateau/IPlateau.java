package plateau;

public interface IPlateau {

	int getJoueur();

	void jouer(String coord);

	Pion getCase(String coord);

	boolean estValide(String coord);

	int taille();
	
	static IPlateau getPlateau(int taille) {
		return new Plateau(taille);
	}

}
