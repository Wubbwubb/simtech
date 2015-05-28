package eigenes.uebung03;

public class ExponentialParameter implements Parameter {
	private double lambda;
	
	public ExponentialParameter(double lambda) {
		this.lambda = lambda;
	}
	
	public double getLambda() {
		return lambda;
	}
}
