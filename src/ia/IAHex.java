package ia;

public abstract class IAHex {
	public abstract String getCoup(String plateau);
	
	public static IAHex getIA(int n) {
		return new IAChatGPT();
	}
}
