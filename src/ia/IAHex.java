package ia;

public abstract class IAHex {
	public abstract String getCoup(String plateau);
	
	public static IAHex getIA(int n) {
		if(n<1) {
			return new IARandom();
		}
		return new IAChatGPT();
	}
}
