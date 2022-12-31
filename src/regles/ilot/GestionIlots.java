package regles.ilot;

import java.util.LinkedList;
import java.util.List;

public class GestionIlots {

	private List<Ilot> ilots;
	private int taille;
	
	public GestionIlots (int taille){
		this.taille = taille;
		this.ilots = new LinkedList<>();
	}
	
	public void ajouterCase(int x, int y, int joueur) {
		System.out.println(joueur);
		Ilot c = new CaseHexa(x, y, joueur);
		boolean adj = false;
		for(Ilot i : ilots) {
			if(i.joueur() == joueur && i.isAdjacent(c)) {
				i.add(c);
				adj = true;
				break;
			}
		}
		if(adj) {
			fusions();
			System.out.println(ilots);
			return;
			
		}
		Ilot ic = new CompositeIlot();
		ic.add(c);
		ilots.add(ic);
		System.out.println(ilots);
	}
	
	private void fusions() {
		boolean changements = true;
		while(changements) {
			changements = false;
			Ilot ii;
			Ilot ij;
			for(int i = 0; i<ilots.size(); i++) {
				ii = ilots.get(i);
				for(int j = i+1; j<ilots.size(); j++) {
					ij = ilots.get(j);
					if(!ii.equals(ij) && ii.isAdjacent(ij) && ii.isMemeJoueur(ij)) {
						System.out.println(ii+" est adj "+ij);
						ii.add(ij);
						
						System.out.println("Je remove "+ij);
						ilots.remove(j);
						changements = true;
					}
				}
			}
		}
		
	}

	public int gagnant() {
		
		for(Ilot i : ilots) {
			if(i.joueur() == 0 && i.isBordEst(taille) && i.isBordOuest())
				return 0;
			
			
			if(i.joueur() == 1 && i.isBordNord() && i.isBordSud(taille))
				return 1;
			
		}
		
		return -1;
	}
}
