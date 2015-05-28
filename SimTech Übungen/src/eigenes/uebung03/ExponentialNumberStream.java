package eigenes.uebung03;

public class ExponentialNumberStream extends
		RandomNumberStream<ExponentialParameter> {

	private static final long serialVersionUID = 1L;

	public ExponentialNumberStream(ExponentialParameter parameter) {
		super(parameter);
	}

	public ExponentialNumberStream(ExponentialParameter parameter, long seed) {
		super(parameter, seed);
	}

	@Override
	public double next() {
		double nextDouble = super.nextDouble();
		return -(Math.log(nextDouble) / getParameter().getLambda());
	}

}
