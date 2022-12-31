package ia;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class IARandom extends IAHex {

	@Override
	public String getCoup(String plateau) {
		int taille = (int) Math.sqrt(plateau.length());
		List<String> possible = new LinkedList<>();
		for(int y=0; y<taille; y++) 
			for(int x=0; x<taille; x++) {
				if(plateau.charAt(x+y*taille) == '.')
					possible.add((char)(x+'A')+""+(1+y));
			}
		if(possible.size()==0) return null;
		Random rand = new Random();
		return possible.get(rand.nextInt(possible.size()));
	}
	
	@Override
	public boolean correspond(int n) {
		return n==0;
	}

}
