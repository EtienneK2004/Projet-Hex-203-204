package regles.ilot;

public class CaseHexa implements Ilot {
    private int y;
	private int x;
	private int joueur;

	// Attributs de la case hexagonale (coordonnées, etc.)
	
	public CaseHexa(int x, int y, int j) {
		this.x = x;
		this.y = y;
		this.joueur = j;
	}

    @Override
    public void add(Ilot ilot) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Ilot ilot) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isAdjacent(Ilot ilot) {
        // Si ilot n'est pas une instance de CaseHexa, on renvoie false
        if (!(ilot instanceof CaseHexa)) {
            return ilot.isAdjacent(this);
        }

        // On récupère les coordonnées de la case hexagonale passée en paramètre
        CaseHexa other = (CaseHexa) ilot;
        int oX = other.getX();
        int oY = other.getY();

        
        int dx = Math.abs(oX - this.x);
        int dy = Math.abs(oY - this.y);

        
        return dx + dy == 1 || 
        		(oX-this.x == 1 && oY-this.y == -1) ||
        		(oX-this.x == -1 && oY-this.y == 1);
    }

	private int getY() {
		return y;
	}

	private int getX() {
		return x;
	}

	@Override
	public boolean isMemeJoueur(Ilot ilot) {
		if (!(ilot instanceof CaseHexa)) {
            return ilot.isMemeJoueur(this);
        }
		CaseHexa other = (CaseHexa) ilot;
		return other.joueur == this.joueur;
	}

	@Override
	public int joueur() {
		return joueur;
	}


	@Override
	public boolean isBordOuest() {
		return x==0;
	}

	@Override
	public boolean isBordNord() {
		// TODO Auto-generated method stub
		return y==0;
	}

	@Override
	public boolean isBordEst(int taille) {
		// TODO Auto-generated method stub
		return x==taille-1;
	}

	@Override
	public boolean isBordSud(int taille) {
		// TODO Auto-generated method stub
		return y==taille-1;
	}
	
	@Override
	public String toString() {
		return "("+x+", "+y+")";
	}

}