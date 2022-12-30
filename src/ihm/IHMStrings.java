package ihm;

enum IHMStrings {
	Bienvenue("Bienvenue au jeu du Hex !"),
	DmdRegle("Voulez vous lire les règles ?"),
	Regle("Les règles du jeu est de former une rangée ininterrompue de pièces de la même couleur qui relie un des côtés du plateau au côté opposé. C´est le joueur qui réussit a relier les faces opposés qui gagnera la partie."),
	DmdRegle1("Voulez vous plus de détail ?"),
	Regle1("Le premier à jouer c'est le joueur 1, si vous voulez jouer contre une IA il suffit d'ajouter un chiffre, si vous voulez que 2 IA s'affronte mettez un chiffre par joueur"),
	Regle2("Les mouvements se succéderont à tour de rôle entre les deux joueurs. Les mouvements ne consistent qu'à ajouter de nouvelles pièces sur le plateau, une par tour. Les pièces déjà déposées sur le plateau ne peuvent pas être déplacées."),
	Regle3("Les joueurs continueront à ajouter des pièces au tableau jusqu´à ce qu´un d´eux emporte la partie."),
	Commencement("Si vous n'avez toujours pas compris demandez à ATN04🐧#6919 sur Discord merci."),
	NomJoueur1("Quel est le nom du premier joueur ?"),
	NomJoueur2("Quel est le nom du deuxième joueur ?"),
	Jouer(", c'est à vous de jouer !"),
	CaseInvalide("Vous ne pouvez pas jouer ici."),
	Gagne(", vous avez gagné!"),
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
