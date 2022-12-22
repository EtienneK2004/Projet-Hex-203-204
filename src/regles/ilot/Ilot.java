package regles.ilot;

public interface Ilot {
    void add(Ilot ilot);
    void remove(Ilot ilot);
    boolean isAdjacent(Ilot ilot);
    boolean isMemeJoueur(Ilot ilot);
    int joueur();
	boolean isBordEst(int taille);
	boolean isBordOuest();
	boolean isBordNord();
	boolean isBordSud(int taille);
    
}
