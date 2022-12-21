package ihm;

enum IHMStrings {
	Bienvenue("Bienvenue au jeu du Hex !"),
	NomJoueur1("Quel est le nom du premier joueur ?"),
	NomJoueur2("Quel est le nom du deuxi�me joueur ?"),
	Jouer(", c'est � vous de jouer !"),
	CaseInvalide("Vous ne pouvez pas jouer ici."),
	Gagne(", vous avez gagn�!"),
	Recommencer("La partie est finie, voulez vous recommencer ?")
	;
	private String message;
	IHMStrings(String string) {
		this.message = string;
	}
	
	@Override
	public String toString() {
		return this.message;
	}
	
}
