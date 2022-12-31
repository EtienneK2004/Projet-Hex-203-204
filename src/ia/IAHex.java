package ia;

public abstract class IAHex {
	
	private static IAHex[] IAs = {new IARandom(), new IAChatGPT()};
	
	public abstract String getCoup(String plateau);
	public abstract boolean correspond(int n);
	
	public static IAHex getIA(int n) {
		for(IAHex ia : IAs) {
			if(ia.correspond(n)) return ia;
		}
		return IAs[0];
	}
}
