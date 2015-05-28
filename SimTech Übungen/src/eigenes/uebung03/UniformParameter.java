package eigenes.uebung03;

public class UniformParameter implements Parameter {
	
	private final int a;
	private final int b;

	public UniformParameter(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public int getA() {
		return a;
	}
	
	public int getB() {
		return b;
	}
}
