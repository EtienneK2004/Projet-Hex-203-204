package regles.ilot;

import java.util.ArrayList;
import java.util.List;

public class CompositeIlot implements Ilot {
    private List<Ilot> ilots;

    public CompositeIlot() {
        ilots = new ArrayList<>();
    }

    @Override
    public void add(Ilot ilot) {
    	if(this.isMemeJoueur(ilot))
    		ilots.add(ilot);
    }

    @Override
    public void remove(Ilot ilot) {
        ilots.remove(ilot);
    }

    @Override
    public boolean isAdjacent(Ilot ilot) {
        // Vérifie si ilot est adjacent à l'un des ilots du composite
        for (Ilot i : ilots) {
            if (i.isAdjacent(ilot)) {
                return true;
            }
        }
        return false;
    }

	@Override
	public boolean isMemeJoueur(Ilot ilot) {
		if(ilots.size() == 0) return true;
        return ilots.get(0).isMemeJoueur(ilot);
	}

	@Override
	public int joueur() {
		if(ilots.size() == 0) return -1;
        return ilots.get(0).joueur();
	}

	@Override
	public boolean isBordEst(int taille) {
		for (Ilot i : ilots) {
            if (i.isBordEst(taille)) {
                return true;
            }
        }
        return false;
	}

	@Override
	public boolean isBordOuest() {
		for (Ilot i : ilots) {
            if (i.isBordOuest()) {
                return true;
            }
        }
        return false;
	}

	@Override
	public boolean isBordNord() {
		for (Ilot i : ilots) {
            if (i.isBordNord()) {
                return true;
            }
        }
        return false;
	}

	@Override
	public boolean isBordSud(int taille) {
		for (Ilot i : ilots) {
            if (i.isBordSud(taille)) {
                return true;
            }
        }
        return false;
	}
	
	@Override
	public String toString() {
		return this.ilots.toString();
	}
}
